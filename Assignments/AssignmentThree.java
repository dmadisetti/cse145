/**
* AssignmentThree: Output a limited combination of numbers
* which the sum of the squares equal a predetermined number
* In this case combination of 4 adding to 200
* .__            __            
* |  |__ ___  __|  | __  ______
* |  |  \\  \/  /  |/ / /  ___/
* |   Y  \>    <|    <  \___ \ 
* |___|  /__/\_ \__|_ \/____  >
*     \/      \/    \/     \/ 
* Hacked together by Dylan Madisetti
*
* @author  Dylan Madisetti
* @version 1.0, Sept 18, 2014
* @source  https://github.com/dmadisetti/cse145
* @website http://dylanmadisetti.com
*/

public class AssignmentThree{

    private final int TARGET = 200; // Total hours
    private final int RECURSION_DEPTH = 3; // 4 straws or 3 counting from 0
    private int[] answers = new int[RECURSION_DEPTH + 1]; // allocate int for each level

    // Constructor to start 
    private AssignmentThree(){
        if(recurse(0,0,1)){ // Run calculation from top
            for (int answer : answers) { // spit out each answer
                System.out.println(answer);
            }
        }else{ // Function returned false. Woops.
            System.out.println("This doesn't look possible kid.");
        }
    }

    private boolean recurse(int depth, int sum, int i){
        if(depth > RECURSION_DEPTH       // Only 4 straws, so stop
            || i * i > TARGET - sum) return false; // not possible to have hours that exceed the target
        int x = i * i;      // Total hours worked
        answers[depth] = i; // store straw incase it works
        return sum + x == TARGET                 // Check to see if it works
            || recurse(depth + 1,sum + x, i + 1) // Check to see if next level + 1 works
            || recurse(depth, sum, i + 1);       // Check to see if this level + 1 works
    }

    public static void main(String args[]){
        // Create instance
        new AssignmentThree();
    }
}

// Notes on this:
// I was hoping for tail recursion optimization, but java doesn't do that.
// Here's a dissection from javap: 
//
//  private boolean recurse(int, int, int);
//    Code:
//       0: iload_1       
//       1: iconst_3      
//       2: if_icmpgt     16
//       5: iload_3       
//       6: iload_3       
//       7: imul          
//       8: sipush        200
//      11: iload_2       
//      12: isub          
//      13: if_icmple     18
//      16: iconst_0      
//      17: ireturn       
//      18: iload_3       
//      19: iload_3       
//      20: imul          
//      21: istore        4
//      23: aload_0       
//      24: getfield      #4                  // Field answers:[I
//      27: iload_1       
//      28: iload_3       
//      29: iastore       
//      30: iload_2       
//      31: iload         4
//      33: iadd          
//      34: sipush        200
//      37: if_icmpeq     69
//      40: aload_0       
//      41: iload_1       
//      42: iconst_1      
//      43: iadd          
//      44: iload_2       
//      45: iload         4
//      47: iadd          
//      48: iload_3       
//      49: iconst_1      
//      50: iadd          
//      51: invokespecial #5                  // Method recurse:(III)Z
//      54: ifne          69
//      57: aload_0       
//      58: iload_1       
//      59: iload_2       
//      60: iload_3       
//      61: iconst_1      
//      62: iadd          
//      63: invokespecial #5                  // Method recurse:(III)Z
//      66: ifeq          73
//      69: iconst_1      
//      70: goto          74
//      73: iconst_0      
//      74: ireturn       
//
// Ideally instuction 63 should be a goto instead of pushing another function on the stack
// Futher reading shows that java purposefully doesn't tail recurse. Why? I don't know, reading 
// online shows that Oracle doesn't care enough to do it. However, it's what's keeping me from 
// setting TARGET = 1000000 and not worrying about a stackoverflow. It should be coming in some 
// version of 8
//
// After writting this snippet on tail recursion I decided to see if a real programming language
// does this- so I wrote the equivilent in C:
//
// #include<stdio.h>
// 
// // Constants
// #define TARGET 200
// #define RECURSION_DEPTH 3
// 
// int answer[RECURSION_DEPTH + 1];
// int x,y;
// 
// int recurse(int depth, int sum, int i);
// 
// main(){
//     recurse(0,0,1);
//     for ( x = 0; x <= RECURSION_DEPTH; x++ ) printf("%d\n",answer[x]);
// }
// 
// int recurse(int depth, int sum, int i){
//     y = i * i;
//     if(depth > RECURSION_DEPTH
//         || y > TARGET - sum) return 0;
//     answer[depth] = i;
//     return sum + y == TARGET 
//         || recurse(depth + 1,sum + y, 1 + i++)
//         || recurse(depth, sum, i); 
// }
// 
// I compiled with `gcc -S -O ./control.c` (to assembly and optimized):
//
// recurse:
// .LFB25:
//     .cfi_startproc
//     pushq   %r12
//     .cfi_def_cfa_offset 16
//     .cfi_offset 12, -16
//     pushq   %rbp
//     .cfi_def_cfa_offset 24
//     .cfi_offset 6, -24
//     pushq   %rbx
//     .cfi_def_cfa_offset 32
//     .cfi_offset 3, -32
//     movl    %edi, %ebx
//     movl    %edx, %ecx
//     imull   %edx, %ecx
//     movl    %ecx, y(%rip)
//     movl    $0, %eax
//     cmpl    $3, %edi
//     jg  .L2
//     movl    %esi, %ebp
//     movl    $200, %esi
//     subl    %ebp, %esi
//     cmpl    %esi, %ecx
//     jg  .L2
//     movslq  %edi, %rax
//     movl    %edx, answer(,%rax,4)
//     leal    (%rcx,%rbp), %esi
//     movl    $1, %eax
//     cmpl    $200, %esi
//     je  .L2
//     leal    1(%rdx), %r12d
//     leal    1(%rdi), %edi
//     movl    %r12d, %edx
//     call    recurse
//     movl    %eax, %edx
//     movl    $1, %eax
//     testl   %edx, %edx
//     jne .L2
//     movl    %r12d, %edx
//     movl    %ebp, %esi
//     movl    %ebx, %edi
//     call    recurse
//     testl   %eax, %eax
//     setne   %al
//     movzbl  %al, %eax
// .L2:
//     popq    %rbx
//     .cfi_def_cfa_offset 24
//     popq    %rbp
//     .cfi_def_cfa_offset 16
//     popq    %r12
//     .cfi_def_cfa_offset 8
//     ret
//     .cfi_endproc
// .LFE25:
//     .size   recurse, .-recurse
//     .section    .rodata.str1.1,"aMS",@progbits,1
//
// I noticed even GCC with the optimize flag doesn't do this! So I tweaked the assembly:
//
// recurse:
// .LFB25:
//     .cfi_startproc
//     pushq   %r12
//     .cfi_def_cfa_offset 16
//     .cfi_offset 12, -16
//     pushq   %rbp
//     .cfi_def_cfa_offset 24
//     .cfi_offset 6, -24
//     pushq   %rbx
//     .cfi_def_cfa_offset 32
//     .cfi_offset 3, -32
//     jmp .L2
// .L2:
//     movl    %edi, %ebx
//     movl    %edx, %ecx
//     imull   %edx, %ecx
//     movl    %ecx, y(%rip)
//     movl    $0, %eax
//     cmpl    $3, %edi
//     jg  .L3
//     movl    %esi, %ebp
//     movl    $200, %esi
//     subl    %ebp, %esi
//     cmpl    %esi, %ecx
//     jg  .L3
//     movslq  %edi, %rax
//     movl    %edx, answer(,%rax,4)
//     leal    (%rcx,%rbp), %esi
//     movl    $1, %eax
//     cmpl    $200, %esi
//     je  .L3
//     leal    1(%rdx), %r12d
//     leal    1(%rdi), %edi
//     movl    %r12d, %edx
//     call    recurse
//     movl    %eax, %edx
//     movl    $1, %eax
//     testl   %edx, %edx
//     jne .L3
//     movl    %r12d,%edx 
//     movl    %ebp, %esi
//     movl    %ebx, %edi
//     jmp .L2              # Here's the important distinction
// .L3:
//     popq    %rbx
//     .cfi_def_cfa_offset 24
//     popq    %rbp
//     .cfi_def_cfa_offset 16
//     popq    %r12
//     .cfi_def_cfa_offset 8
//     ret
//     .cfi_endproc
// .LFE25:
//     .size   recurse, .-recurse
//     .section    .rodata.str1.1,"aMS",@progbits,1
//
// I ran some benchmarks to test whether this really matters. GCC is usually pretty
// good about optimization, so if they didn't see a reason to put in this particular
// one then I was starting to doubt whether this really mattered at all
// 
// Results for control:
// sudo chrt -f 99 /usr/bin/time --format="\t %e Time\n\t %M Maximum memory use" bash -c "for i in {1..100000};do ./control; done" > /dev/null
//   125.42 Time
//   20124 Maximum memory use
//
// Results for optimized:
// sudo chrt -f 99 /usr/bin/time --format="\t %e Time\n\t %M Maximum memory use" bash -c "for i in {1..100000};do ./optimized; done" > /dev/null
//   124.83 Time
//   20124 Maximum memory use
//
// So optimization saved us 590ms, woot! but made virtually no memory difference
// I ran it again, because I might have sneezed
//
// Results for control:
// sudo chrt -f 99 /usr/bin/time --format="\t %e Time\n\t %M Maximum memory use" bash -c "for i in {1..100000};do ./control; done" > /dev/null
//   124.83 Time
//   20124 Maximum memory use
//
// Results for optimized:
// sudo chrt -f 99 /usr/bin/time --format="\t %e Time\n\t %M Maximum memory use" bash -c "for i in {1..100000};do ./optimized; done" > /dev/null
//   125.27 Time
//   20120 Maximum memory use
//
// Lost 440ms, darn. On the flip side I saved 4kb. Woot? Maybe I sneezed again, 
// but ultimately I've determined for small instances like this, it doesn't really 
// matter. In addition, my environment is obviously not deterministic, so any minor
// performance gains or losses really can't be measured with any great certainty.
// There might be cases where tail end does matter, for example when each instance
// of the function has more than a couple values shoved into its registers, but this
// is not one of those programs