# BFUtils
Inside of this package, there is a set of potentially useful utilities based around the Brainf**k esolang. Currently, it contains an interpreter for both BF and BF++, along with a transpiler that converts BF code to C.

# Brainf**k
Brainf**k (BF) is an incredibly popular esoteric programming language created in 1993 by Urban Müller. The language consists of what some might refer to as "pure" memory management, as all one does while programming in it is increment or decrement values, along with a single data pointer. It contains a grand total of 8 instructions, which only allow for basic looping, user input, and output (however, people have been able to do some pretty impressive things with it, check out https://esolangs.org/wiki/Brainfuck_algorithms). 
Here's a list of the instructions...

| Instruction | Description |
| --- | --- |
| + | Increments the value at the data pointer |
| - | Decrements the value at the data pointer |
| > | Increment the data pointer's address |
| < | Decrements the data pointer's address |
| , | Get 1 character of user input and store it at the data pointer |
| . | Print the character at the data pointer |
| \[ | Jumps to next \] if the value at the data pointer is 0 |
| \] | Jumps back to the previous \[ if the value at the data pointer is not 0 |

# Brainf**k++
Brainf**k++ is an extension of BF originally created by Jacob I. Torrey. However, I have added a number of new features/specifications to the language, as the Esolang page for the language (http://esolangs.org/wiki/Brainfuck++) provides very few details on how the extended instructions are actually meant to work. BF++ adds support for basic file I/O and socket programming, making it *slightly* more useful for everyday use. Here's a list of the extended instructions...

| Instruction | Description |
| --- | --- |
| # | Reads until the next empty memory cell, and either opens the data as a file to overwrite or closes the open file |
| & | Same as the previous instruction, but opens the file in order to append it |
| ; | Write the value at the data pointer to the open file |
| : | Reads one character in the open file and puts it in the current memory cell |
| % | Reads the next 5 bytes in memory, interprets them as an IP address/port, and open a socket connection |
| ^ | Sends the value at the data pointer over the open socket |
| ! | Recieves one byte from the socket and puts it in the current memory cell |

# List of included utilities
### StandardBF
The pure Brainf**k interpreter. This also includes the C transpiler, because, at the moment, that tool only supports raw BF.

#### Usage
```
Usage: java -jar StandardBF.jar [-h] [-C] <File>
Arguments:
  -h  : List this information  
  -C : Compile to C
```
### BrainFuckPP
The Brainf**k++ interpreter.

#### Usage
```
Usage: java -jar BrainFuckPP.jar [-h] <File> 
Arguments:
  -h  : List this information
```
### BFtoC
The C transpiler class, which is combined with the StandardBF package.

# Potential TODO's
In the future, I may add a number of new utils to this repository. I will definetly be updating the code in all of the classes, as they are still missing some painfully obvious error handling statements (also some of the code is bad, and I'll try to fix that). The most likely *large* additions to this project will consist of BF++ transpiler support and a basic Brainf**k(++) debugger, although those things really just depend on how much time and motivation I have. There's also a high chance that I'll add some more CLI features to each of the tools.
### An Unimportant Note
This project started as something to do while I was bored in computer science class... I spent way too much time on it.
