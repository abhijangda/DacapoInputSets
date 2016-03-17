from contextlib import closing
from itertools import islice
from sys import argv, stdout
class Test:
    pass

def cpu_count():
    return 1

def pixels(y, n, abs):
        range7 = bytearray(range(7))
        pixel_bits = bytearray(128 >> pos for pos in range(8))
        c1 = 2. / float(n)
        c0 = -1.5 + 1j * y * c1 - 1j
        x = 0
        while True:
            pixel = 0
            c = x * c1 + c0
            for pixel_bit in pixel_bits:
                z = c
                for _ in range7:
                    for _ in range7:
                        z = z * z + c
                    if abs(z) >= 2.: break
                else:
                    pixel += pixel_bit
                c += c1
            yield pixel
            x += 8

def compute_row(p):
    y, n = p

    result = bytearray(islice(pixels(y, n, abs), (n + 7) // 8))
    result[-1] &= 0xff << (8 - n % 8)
    return y, result

def ordered_rows(rows, n):
    order = [None] * n
    i = 0
    j = n
    while i < len(order):
        if j > 0:
            row = next(rows)
            order[row[0]] = row
            j -= 1

        if order[i]:
            yield order[i]
            order[i] = None
            i += 1

def compute_rows(n, f):
    row_jobs = ((y, n) for y in range(n))
    print 'ccc'
    yield map(f, row_jobs)
            
class Mandelbrot (Test):
    version = 1.0
    operations = 10
    rounds = 10

    def test(self, n = 10000):
        for i in xrange(self.rounds):
            write = stdout.write
            print i
            rows = compute_rows(n, compute_row)
            
    def calibrate(self):
        for i in xrange(self.rounds):
            pass

Mandelbrot().test()
