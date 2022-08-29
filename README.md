# Lab: Variables & Manipulations II

## INTRODUCTION
The first computer bug was found by famed Computer Scientist and U.S. Navy Rear Admiral Grace Hopper when working with the Harvard Mark II computer. In that famous incident, a moth had flown into the innards of the computer shorting out one of the connections inside. This incident became the first recorded uses of the term “computer bug”.

Today, software systems are more complex and powerful than ever, but as the size and scope of a system grows, so do the bugs that inhabit it. Debugging, or the process of eliminating bugs, is the most important part of software development. Most estimates say that programmers spend 75% of their working time debugging. As software systems get more complex, the bugs simply get harder and harder to find. Thankfully, over the years people have built many tools to handle this process of finding and eliminating tools called Debuggers. In fact, most IDEs are bundled with their own debuggers to help programmers figure out where the bugs are hidden in their code. Today, we’ll be going over how to use the Java debugger that is built into Eclipse.

## INSTRUCTIONS
You’ll be working with an already written program that is a “Mindfulness Calculator”. The goal of the program is to accept user input for the amount of time they spend doing certain things during the week, and then give them an overview of how much of their week goes to each task. 

The program has a few bugs that need to be fixed. These bugs range from simple runtime errors to more complex logic errors. While there are numerous ways you can solve the issues in this program, using the debugger is by far the best way to do so. 

### PART 1: RUNTIME BUG (EXCEPTION)

1.	**RUN THE PROGRAM:** Let’s run the program to see where things are. If all went well, the following (or something similar) should print in the Console:
    ```Welcome to the Jeffrey S. Raikes School Mindful Week Calculator.

    Please answer the following questions as best you can. Feel free to enter estimates or 0 if the question is not applicable.

    Please enter the number of hours you spend per week in class, studying, or working on homework: Exception in thread "main" java.lang.NullPointerException
    at edu.unl.raikes.MindfulWeekCalculator.main(MindfulWeekCalculator.java:43)
    ```

2.	**EVALUATE THE ISSUE:** Assuming you were able to run the lab correctly. You should have seen a bright red exception message pop up. Exceptions are a program’s way of telling the programmer that something happened during the execution of the program that shouldn’t have. Errors like this are called runtime errors because they happen at the time a program is run. The first step to dealing with these issues is always to check the stack trace. 

3.	**DECODE THE STACK TRACE:** Looking at the stack trace for the exception we can see a couple of things. First, we can see that the Exception thrown was a NullPointerException and we can also see that it was thrown at MindfulWeekCalculator.java:43. This gives us two things to investigate. 

4.	**CHECK THE JAVA DOCS:** A NullPointerException is one that is pretty commonly seen in Java programs and one that you’ll get great at solving in no time. If you’re not familiar with the Exception in question, a great first step to take is to try and find the JavaDocs for that Exception.  You can easily find the docs for a given Exception by searching for “Java <Exception Name>” on the Internet. For example, a quick search for “Java NullPointerException” revealed the JavaDocs for the exception which you can find here: (https://docs.oracle.com/javase/7/docs/api/java/lang/NullPointerException.html). Skimming over the page, we can see that a NullPointerException is thrown when “calling the instance method of a null object”. Let’s investigate further. 

5.	**FOLLOW THE STACK TRACE:** Now that we know why the exception may have been thrown, let’s investigate the code where the Exception was thrown.  Looking at the console output again, you can see that Eclipse has given us a link to click on to go to the line where the Exception was thrown. You can see that the exception was thrown when the inputScanner.nextInt() method was called. Well, let’s check where the Scanner is declared. If you right click on the variable name, you can select “Open Declaration” and Eclipse will show you where the declaration of it is. See the problem? If not, look at your notes for creating a Scanner. Think about what needs to be done to get a working scanner. Give that a fix and run the program again. It should properly ask you for input now. Great job fixing that bug! Let’s move on to the next ones. 

### PART 2: TYPE BUG
1.	**RUN THE PROGRAM:** Now that the program seems to be running, let’s run it and see if anything else goes wrong when it runs. Follow the prompts and enter the information as desired. Once everything is entered you should get a report summary of your activities in the week. Wait a second, that doesn’t look right. Your mileage may vary but see below for what my input and output looked like. 
    ```Please enter the number of hours you spend per week in class, studying, or working on homework: 20
    Please enter the average amount of time you take to eat a meal in minutes: 30
    Please enter the average amount of time you take to get ready in the morning in minutes: 30
    Please enter the average amount of hours per week you work: 10
    Please enter the average amount of sleep you get per night in hours: 8
    Please enter the average amount of time you spend doing sedentary tasks (tv, video games, etc) per week in hours: 10
    Please enter the average amount of time you spend being active (sports, running, etc) in a week in hours: 10

    YOUR MINDFULNESS REPORT:
    Here is how you spend your week...

    STUDYING:                    0%
    EATING:                      0%
    GETTING READY FOR THE DAY:   1%
    WORKING:                     0%
    SLEEPING:                    0%
    DOING SEDENTARY THINGS:      0%
    DOING ACTIVE THINGS:         0%
    OTHER:                       0%

    There were -158 hours unaccounted for by our tool.
    ```

2.	**EVALUATE THE ISSUE:** Let’s break down what happened. The input seems correct from what we can see. However, none of those percentages look like percentages. Also, -158 hours being unaccounted for seems like an issue, but let’s try and tackle the percentage calculation first and see if we can’t get that working right. Now we could modify the code and then run it again to see if we can fix it, however then we would have to enter all those number again. Instead, to save time and headaches, let’s try and use the debugger. 

3.	 **SET A BREAKPOINT:** The most basic form of debugging, and the one that you’ll use most in this class, is debugging with the use of breakpoints. Breakpoints are points in your code where you specify the program should “break” or stop at when it hits that point. From there, the program is frozen, and you can either let it run again or “step through” it, going line by line and watching how the code is executed. When selecting a breakpoint, you want to select a line near where the issue is occurring. Since the error in the application is most likely in the calculation of the percentages, that is a good place to start. Let’s place a breakpoint on the line where the percentStudying variable is declared.  To set a breakpoint in Eclipse, find the line where you want the breakpoint to occur and then right click on that line’s number. From there, select “Toggle Breakpoint”. 

4.	**EXECUTE THE DEBUGGER:** Now that your breakpoints are set, you can execute the debugger. In Eclipse, select the “Debug” button on the top ribbon. It should be right next to the “Run” button and looks like a bug. After selecting this, follow the prompts in the program and enter all of information like before. When you hit the point in the program where you set your breakpoint, a dialog should pop up that asks you to switch to the Debug Perspective, select “Switch”. You’re now in the Eclipse Debugger. Look around, you’ll see everything has changed. On the right, you’ll see all the variables that are currently within scope. In the center you’ll see your code and the console and the current like is highlighted. Your program is currently frozen on the selected line, next we’ll orient ourselves with some of the new information presented to us in the debugger.

5.	**ORIENT YOURSELF WITH THE DEBUGGER:** Now that we’ve stopped our program. Let’s take a moment to see everything. Check the Variables tab on the right and read over each variable and its value. Judging from the values stored, it seems that our input is being read in properly and stored so that isn’t the issue. Let’s “step through” the program and see what happens. On the top, you’ll see that next to the red “Terminate” button, there are new buttons which look like smaller arrows pointing a certain way. Hover over these buttons to see what they’re named. The “Step Into” button steps into a method call. That is, if you’re calling inputScanner.nextInt(); it will go into the code that makes up that nextInt() method. Good in certain cases, however not useful for us now. The “Step Over” button will step over any method calls that occur but still go line by line. This seems like the best choice for us. These two buttons are the main buttons you’ll use in the debugger. They let you step, line-by-line, through an application.

6.	**STEP THROUGH THE PROGRAM AND FIX THE BUG:** Hit “Step Over” a couple of times making sure to watch what happens in the Variables tab. Well, we see that our calculated percent values are all zeros! Let’s investigate the arithmetic a little bit. We know that the input variables are not zero. If we look at the declaration of the NUM_HOURS_IN_WEEK constant, we know that isn’t zero either. But what do we notice about each of those variables? They’re integers! We’ve been caught in the integer division trap! Let’s fix this. Hit the red “Terminate” button to stop the program. You’ll see that the program stops, but we’re still in the Debugging view. To change back to the original view, click the button in the top right of your window that looks like a collection of shapes and the letter J, this button will return your screen to the standard view. Now, make the fixes to ensure this calculation happens correctly. Double check that your percentage calculations are correct. Remember 0.45% isn’t the same as 45%. 

### PART 3: LOGIC BUG
1.	**RUN THE PROGRAM:** We’ve knocked two bugs out of the park. Let’s check in and see where we are. Run the program again, providing valid inputs, and see what happens. Assuming everything you put in was a valid input, things should look a little off. In fact, with my input from before, it told me that I had negative hours left in the week. Something is awry. This is the hardest type of bug to investigate, a logic bug. It is one that doesn’t cause the program to crash but instead causes unexpected behavior. 

2.	**FIND THE BUG:**  Now that we’ve seen how to set breakpoints and use the debugger, give it a try yourself. Set a breakpoint near the top of the program after the welcome message at the start of the user input. Execute the debugger and use the “Step Over” button to walk through your program. Make sure to carefully read each line and look at the resulting variable value. Look and see if the value that is set in the variable makes sense after every line. Keep stepping through until you identify a calculation or input that looks wrong. When you find it, you’ve most likely found the bug!

3.	**FIX THE BUG:** Now that you know where the bug is, fix it. Run the program again and make sure to ensure that the bug is fixed, and the final output of the program looks valid. At this point, you’re done. Great job wrangling your first bugs! Make sure you commit and push your code to GitHub so that it can be assessed.
![image](https://user-images.githubusercontent.com/3309783/187246240-61e1c561-ed73-4831-938d-19f31cd228e3.png)
