; @Harness: disassembler
; @Result: PASS
  section .text  size=0x0000000e vma=0x00000000 lma=0x00000000 offset=0x00000034 ;2**0 
  section .data  size=0x00000000 vma=0x00000000 lma=0x00000000 offset=0x00000042 ;2**0 

start .text:

label 0x00000000  ".text":
      0x0: 0xf8 0x94  cli
      0x2: 0x88 0x94  clc
      0x4: 0xb8 0x94  clv
      0x6: 0x98 0x94  clz
      0x8: 0xe8 0x94  clt
      0xa: 0xd8 0x94  clh
      0xc: 0xa8 0x94  cln

start .data:

