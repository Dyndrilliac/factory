*******************************************************************

* Title:     Factory
* Author:    [Matthew Boyette](mailto:N00868808@ospreys.unf.edu)
* Class:     Operating Systems (COP 4610)
* Professor: Dr. Sanjay Ahuja
* Term:      Fall 2017

*******************************************************************

This is a standalone Java project for Operating Systems (COP 4610) to demonstrate a solution to the Consumer-Producer problem relating to concurrent multithreading.

# File Listing

Source Code:

* ***Factory.java***: Thread pool manager code and program entry-point.
* ***Consumer.java.java***: Consumer thread code.
* ***Producer.java***: Producer thread code.
* ***MessageQueue.java***: Thread-safe concurrent FIFO queue implementation of Channel.
* ***Channel.java***: Definition of abstract Channel interface for synchronized communication between threads.
* ***SleepUtilities.java***: Support code for randomly delaying thread execution.

Support:

* ***README.md***: this file, the program's documentation.
* ***LICENSE.md***: please use this software responsibly!
* ***makefile***: a standard makefile for a Unix-like development environment.

# Compilation

* make

# Execution

* make exec

# Clean Up

* make clean
