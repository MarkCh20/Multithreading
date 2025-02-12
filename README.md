# Java Multithreading Project

This project demonstrates the power of multithreading in Java through two unique tasks: a real-time timer application and a FizzBuzz implementation using multiple threads. By leveraging Java's concurrency utilities, semaphores, and blocking queues, the project efficiently manages thread synchronization, ensuring smooth and structured execution.

## Table of Contents

1. [Introduction](#introduction)
2. [Features](#features)
3. [Technologies Used](#technologies-used)
4. [Implemented Tasks](#implemented-tasks)

## Introduction

Multithreading is a core concept in Java that enables efficient execution of parallel tasks. This project showcases practical implementations of multithreading through two tasks:

1. **Task 1:** A real-time timer application that prints elapsed time every second and a separate message every five seconds.

2. **Task 2:** A multithreaded FizzBuzz program that distributes number evaluation across multiple threads to enhance efficiency and maintain proper ordering of output.

These tasks illustrate how to coordinate multiple threads using synchronization mechanisms like semaphores and blocking queues while ensuring smooth execution without race conditions.

## Features

- **Efficient Thread Synchronization:** Uses Java's concurrency utilities to manage multi-thread execution.

- **Precise Timing:** Timer Application ensures accurate time tracking and message intervals.

- **Parallel Processing of FizzBuzz Logic:** FizzBuzz assigns different responsibilities to different threads for optimized execution.

- **BlockingQueue for Safe Communication:** Ensures data consistency between threads.

- **Semaphore-Based Thread Control:** Manages access to shared resources without conflicts.

- **Scalable & Extendable:** Can handle increased workload with minimal modifications.

## Technologies Used

- Java

- Java Concurrency API

- Threads & Runnables

- Semaphores

- BlockingQueue

- Synchronized Execution

## Implemented Tasks

### 1. **Real-Time Timer Application**
**Purpose:**
- Displays elapsed time every second.
- Prints a message every 5 seconds.
- Stops execution after a predefined duration.

**Key Concepts Used:**
- Threads for parallel execution.
- Sleep for interval-based output.
- Interrupt handling for graceful thread termination.


### 2. **Multithreaded FizzBuzz**
**Purpose:**

- Prints numbers from 1 to N with specific replacements:
  - "fizz" for multiples of 3
  - "buzz" for multiples of 5
  - "fizzbuzz" for multiples of both 3 and 5
- Uses four separate threads to divide responsibilities.
- Ensures output follows the correct sequence.

**Key Concepts Used:**
- Separate threads for checking divisibility by 3, 5, and both.
- Semaphore-based synchronization.
- BlockingQueue to manage output order.
- Ensures proper sequence without race conditions.

This project serves as an excellent introduction to Java multithreading, providing hands-on experience with synchronization, inter-thread communication, and performance optimization techniques.


