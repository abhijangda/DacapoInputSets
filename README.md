# DacapoInputSets

Each benchmark has to be build and executed in a different way. The input set is available for the following benchmarks:
* pmd
* lusearch
* luindex
* avrora
* jython

## pmd
pmd benchmark has to be build before using the "custom" input set. benchmarks/bms/pmd/pmd.cnf file describes the configuration file for pmd. custom size and its arguments are described in this file. "@pmd/rvm.lst" describes the path of lst file which contains the paths of java files to be parsed. benchmarks/bms/pmd/data/pmd/rvm.lst is the file describing path of java files to be parsed. benchmarks/bms/pmd/data/pmd/testsrc/net/pmd/net/sourceforge/pmd/rvm/src/org/jikesrvm contains all the java files to be parsed.

To execute pmd run

cd benchmarks/
ant pmd
java -jar dacapo.jar pmd -s custom

## luindex
luindex can be accessed through already compiled dacapo benchmarks. dacapo/cnf/luindex.cnf is the configuration file of luindex. Arguments for custom size "luindex/scammell", "luindex/galaxy" are present in dacapo/data/luindex.zip. 

To execute luindex run

cd dacapo
java Harness luindex -s custom

## lusearch
Similar to luindex, lusearch can be executed from compiled dacapo files. dacapo/cnf/lusearch.cnf is the configuration file of lusearch. Arguments for custom size are present in dacapo/scratch/lusearch/index-custom. These files were generated using luindex's custom size.

TODO: Add how to generate segments file using luindex 


