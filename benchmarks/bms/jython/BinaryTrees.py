import sys
#import multiprocessing as mp
from pybench import Test
class BinaryTrees(Test):
    version = 1.0
    operations = 10
    rounds = 10
    
    def make_tree(self, i, d):

        if d > 0:
            d -= 1
            return (i, make_tree(i, d), make_tree(i + 1, d))
        return (i, None, None)


    def check_tree(self, node):

        (i, l, r) = node
        if l is None:
            return i
        else:
            return i + check_tree(l) - check_tree(r)


    def make_check(self, itde, make=make_tree, check=check_tree):

        i, d = itde
        return check(make(i, d))


    def get_argchunks(self, i, d, chunksize=5000):

        assert chunksize % 2 == 0
        chunk = []
        for k in range(1, i + 1):
            chunk.extend([(k, d), (-k, d)])
            if len(chunk) == chunksize:
                yield chunk
                chunk = []
        if len(chunk) > 0:
            yield chunk


    def test(self, n, min_depth=4):
        for i in xrange(self.rounds):
            max_depth = max(min_depth + 2, n)
            stretch_depth = max_depth + 1
            chunkmap = map

            print('stretch tree of depth {0}\t check: {1}'.format(
                  stretch_depth, self.make_check((0, stretch_depth))))

            long_lived_tree = self.make_tree(0, max_depth)

            mmd = max_depth + min_depth
            for d in range(min_depth, stretch_depth, 2):
                i = 2 ** (mmd - d)
                cs = 0
                for argchunk in self.get_argchunks(i,d):
                    cs += sum(chunkmap(make_check, argchunk))
                print('{0}\t trees of depth {1}\t check: {2}'.format(i * 2, d, cs))

            print('long lived tree of depth {0}\t check: {1}'.format(
                  max_depth, self.check_tree(long_lived_tree)))

    def calibrate(self):
        for i in xrange(self.rounds):
            pass
