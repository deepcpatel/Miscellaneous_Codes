//Manually strore 1st no in the memory location C100
// Manually store 2nd no in the memory location C101
// Result is stored in C102, & C103
# BEGIN C000H
	   LDA C101
	   MOV B,A
	   LDA C100
	   MOV C,A
	   MVI A,00
	   MVI D,00

LOOP:	   ADD B
	   JC CARRY

DECR:	   DCR C
	   JNZ LOOP
	   JMP STORE

CARRY:	   INR D
	   JMP DECR

STORE:	   STA C102
	   MOV A,D
	   STA C103
	   HLT
// EXAMPLE -> C100 = 10H, C101 = 23H
// ANSWER-> C102 = 30H, C103 = 02H
# ORG C100
# DB 10H,23H
