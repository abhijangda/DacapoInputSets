/* Copyright (c) Jython Developers */
package org.python;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Properties;
import java.util.Set;

import org.python.core.CodeFlag;

/**
 * Jython version information.
 *
 * The version number and build information are loaded from the
 * version.properties file, located in this class file's
 * directory. version.properties is generated by ant.
 */
public class Version {

    /** The current version of Jython. */
    public static String PY_VERSION;

    /** Tokenized version. */
    public static int PY_MAJOR_VERSION;
    public static int PY_MINOR_VERSION;
    public static int PY_MICRO_VERSION;
    public static int PY_RELEASE_LEVEL;
    public static int PY_RELEASE_SERIAL;

    /** Timestamp and revision number of the current build. */
    public static String DATE;
    public static String TIME;
    public static String SVN_REVISION;

    /** Determined from headURL, branch is the path under the
     * subversion root, e.g. branches/asm. */
    public static String BRANCH;

    /** Short version of branch, e.g. asm. */
    public static String SHORT_BRANCH;

    /** The flags that are set by default in a code object. */
    private static final Collection<CodeFlag> defaultCodeFlags = Arrays.asList(
            CodeFlag.CO_NESTED, CodeFlag.CO_GENERATOR_ALLOWED);

    private static final String headURL =
            "$HeadURL: https://svn.code.sf.net/p/jython/svn/trunk/jython/src/org/python/Version.java $";

    static {
        initVersion();
    }

    /**
     * Load the version information and determine BRANCH and
     * SHORT_BRANCH from headURL.
     */
    private static void initVersion() {
        loadProperties();

        int jython = headURL.indexOf("/jython/");
        if (jython > -1) {
            int brStart = jython + 8;
            String end = headURL.substring(brStart, headURL.length());

            if (end.startsWith("trunk/")) {
                BRANCH = SHORT_BRANCH = "trunk";
                return;
            } else if (end.startsWith("tags/") || end.startsWith("branches/")) {
                int brEnd = end.indexOf('/');
                int brEnd2 = end.indexOf('/', brEnd + 1);
                if (brEnd2 > -1) {
                    BRANCH = end.substring(0, brEnd2);
                    SHORT_BRANCH = end.substring(brEnd + 1, brEnd2);
                    return;
                }
            }
        }
        BRANCH = "";
        SHORT_BRANCH = "unknown";
    }

    /**
     * Load the version information from the properties file.
     */
    private static void loadProperties() {
        boolean loaded = false;
        final String versionProperties = "/org/python/version.properties";
        InputStream in = Version.class.getResourceAsStream(versionProperties);
        if (in != null) {
            try {
                Properties properties = new Properties();
                properties.load(in);
                loaded = true;
                PY_VERSION = properties.getProperty("jython.version");
                PY_MAJOR_VERSION = Integer.valueOf(properties.getProperty("jython.major_version"));
                PY_MINOR_VERSION = Integer.valueOf(properties.getProperty("jython.minor_version"));
                PY_MICRO_VERSION = Integer.valueOf(properties.getProperty("jython.micro_version"));
                PY_RELEASE_LEVEL = Integer.valueOf(properties.getProperty("jython.release_level"));
                PY_RELEASE_SERIAL = Integer.valueOf(properties.getProperty("jython.release_serial"));
                DATE = properties.getProperty("jython.build.date");
                TIME = properties.getProperty("jython.build.time");
                SVN_REVISION = properties.getProperty("jython.build.svn_revision");
            } catch (IOException ioe) {
                System.err.println("There was a problem loading ".concat(versionProperties)
                        .concat(":"));
                ioe.printStackTrace();
            } finally {
                try {
                    in.close();
                } catch (IOException ioe) {
                    // ok
                }
            }
        }
        if (!loaded) {
            // fail with a meaningful exception (cannot use Py exceptions here)
            throw new RuntimeException("unable to load ".concat(versionProperties));
        }
    }

    /**
     * Return the current subversion revision number. May be an empty
     * string on environments that can't determine it.
     */
    public static String getSubversionRevision() {
        return SVN_REVISION;
    }

    /**
     * Return the current branch name.
     */
    public static String getSubversionShortBranch() {
        return SHORT_BRANCH;
    }

    /**
     * Return the current build information, including revision and
     * timestamp.
     */
    public static String getBuildInfo() {
        String revision = getSubversionRevision();
        String sep = "".equals(revision) ? "" : ":";
        String branch = getSubversionShortBranch();
        return String.format("%s%s%s, %.20s, %.9s", branch, sep, revision, DATE, TIME);
    }

    /**
     * Describe the current Java VM.
     */
    public static String getVM() {
        return String.format("\n[%s (%s)]", System.getProperty("java.vm.name"),
                             System.getProperty("java.vm.vendor"));
    }

    /**
     * Return the Python version, including compiler (or in our case,
     * the Java VM).
     */
    public static String getVersion() {
        return String.format("%.80s (%.80s) %.80s", PY_VERSION, getBuildInfo(), getVM());
    }

    public static Set<CodeFlag> getDefaultCodeFlags() {
        return EnumSet.copyOf(defaultCodeFlags);
    }
}
