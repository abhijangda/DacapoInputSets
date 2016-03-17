import sys
from pybench import Test

def main():
  # CSF - Use gmpy2's divmod instead of the Python built-in, it's slightly faster

  N = int(1000)

  # CSF - Used by bprint below to save a few usec off each print
  line = '{:010d}\t:{}\n'.format

  # CSF - Not very PEP friendly, but the runtime on this benchmark is low, and
  # this is faster than multiple single line assignments
  n, a, d, t, u, i, k, ns, k1 = 1, 0, 1, 0, 0, 0, 0,  0,  1

  while True:
    k += 1
    t = n<<1
    n *= k
    a += t

    k1 += 2
    a *= k1
    d *= k1
    if a >= n:
      t, u = divmod(n * 3 + a, d)
      u += n
      if d > u:
        ns = ns * 10 + t
        i += 1
        if not i % 10:  # CSF - faster way of saying if i % 10 == 0
          #print (line(ns, i).encode())
          ns = 0
          if i >= N:
             break
        a -= d * t
        a *= 10
        n *= 10

class NBody(Test):
    version = 1.0
    operations = 10
    rounds = 20

    def test (self):
        for i in xrange(self.rounds):
            main ()

    def calibrate (self):
        for i in xrange(self.rounds):
            pass

if __name__ == '__main__':
  main()
    
