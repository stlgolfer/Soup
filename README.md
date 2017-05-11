# Soup
*A language interpreted through Java to make computing easier and more efficient*

# Basic Functions (Poly-Argumented Functions)
Soup can do these basic math functions along with other functions. Functions will continuously calculate the arguments left to right.

Legend

`i{f,e}`

where 

Token | Description
---- | ---
i | the indentifier
f | first paramater
e | second paramater

Example

`+{4,5,5}` -> `14`
`%{12,2,2}` -> `3` (12/2 -> 6, 6/2 -> 3)

Key: italics denotes that the function only takes one argument

Token | Operation
----- | -----
`+` | Adding
`_` | Subtracting
`*` | Multiply
`%` | Divide
`^` | Raise to the Power Of (base,exponent)
`#` | Logarithm (exponent,base)
`P` | Print (e = 1 print, e = 0 for print line)
`{pipe}` | Absolute Value of single number
`&` | *Square Root*
`?` | *Rounds the number*
`~` | Stores a variable at a specific index `~{3,0} // number 3 at index 0`
`/` | Comments (jumps index to the end of the line; doesn't work in loops, so don't put them in loops)
` ` | Only a single space between functions is permitted (it's proper to use a period, though)

# Random Number Generation (Static-argumented)
Soup can return a random integer to your specifications

## Legend

`R{0,4}`

Returns a random float between 0 and 4

# Trig Functions
_Please note that trig functions return in RADIANS so be aware and plan accordingly_

Key

`${f,e}`

where

`f` Case | `e` Function
------ | -------
`s` | Sine of number
`c` | Cosine of number
`t` | Tangent of number
`arcs` | Arc Sine
`arcc` | Arc Cosine
`arct` | Arc Tangent

# Area Functions
Soup can also calculate areas for you with ease

Key

`A{f,e}`

where

`f` case | `e` function
------ | -------
`s` | Finds the area of a square `A{s,4,4}` -> `16`
`tri` | Finds the ara of a triangle `A{tri,4,4}` -> `8`
`tra` | Trapezoid `A{tra, 4,4}`

# Variable Storage
Variable storage is a critical piece to Soup. The function acts like an extension of a regular function

Token | Operation | Example
---- | ---- | -----
`:` | Stores the last operation's output in the specific index (excluding print) | `+{5,5}:{0}`
`~` | Stoes the first argument in the second argument's index | `~(3,0) // this will put 3 in index 0`

# Variable Retrieval
## Explicit Recalling
Variables can be called from within functions or just printed to the screen

If you want to just recall a variable:

`V{0}`

where 0 is the index that you want to pull from.

## Interpolated Recalling
Variables can be recalled from within functions for interpolation and manipulation

For example:

```
~{3,0} // stores '3' in index 0
+{v0,3} // v0 will substitute the recalled variable at index 0 and add it with 3 to get the answer. note that the interpolated 'v' is lowercase
```

# Getting User Input
In Soup, you can accept the user's input and store it like this:

` I{What's the number?,0} `


The first paramater is the string and the second paramater is the index where the input will be stored

## Wildcards
User's inputs can be indentified as wildcards

Token | Result
--- | ---
{grave} | sets variable in position 100 to 1
`.` | sets variable in position 101 to 1

### Applied meaning
Example
```
I{type '`' for hydrogen,1}. ={v100,1};(~{-1,5}.V{5}!.P{calculating helium then...,1}.^{2,2}:{2}.*{-13.6,v2}:{2}.^{1,2}:{3}.%{v2,v3})
P{done,1}
```

The point? You can compare user input with things other than numbers! Menu systems! Options!

# Miscellaneous Characters
These are characters that have some special functions

Token | Operation | Notes
------- | -------- | ----
`.` | End of function | it's like a semicolon, it's not necessary but it's there for making code easier to read

# Looping
Soup can do for loops, while loops, and while not loops. To break a loop, use `X`

## For Loops
For loops will increment the first argument until (about) the second argument is equal to it. Now, like a regular for loop, you can access the current index in which the loop is on. The index is stored in variable position 1000. Remember, to recall: `V{1000}` for interpolation (example): `[{0,5}].+{v1000,4}` **however,** you can't set this variable, only access it 

### Example
`[{0,3}].P{hello,1}` -> This will print the "hello" ~3 times

## While Loop
While loops will run while argument 1 and 2 are equal. Please note that variables can be accepted as numbers.

### Examples
`W{1,1}.P{hello,1}` -> this will print "hello" infinately times

`W{v0,0}.+{v0,1}:{0}` -> this loop will only run once

## While Not Loop
While loops will run while argument 1 and 2 are not equal. Please note that variables can be accepted as numbers.

### Examples
`N{1,0}.P{hello,1}` -> this will print "hello" infinately times

`N{v0,1}.+{v0,1}:{0}` -> this loop will only run once

# If Statements (Static-Arguments)
Quite possibly the most useful function in Soup. Please read careful as this breaks some rules when it comes to syntax

## The Basic If Statement
`={0,0}` -> will print "True" if the first and second arguments match. Prints "False" on the opposite

## > If Statement
`>{4,3}` -> will print "True" if the first argument is greater than the second argument. Prints "False on the opposite

## < If Statement
`<{4,3}` -> will print "True" if the first argument is less than the second argument. Prints "False on the opposite

## Soup If Do
This is where things get complicated as the syntax will change. To explain: whenever an if statement function is executed, it caches the result. This means that we can manipulate it by extending the function like the store function extenstion!

### Primitive Syntax 
`;(!)` -> If the cached statement is true, execute everthing before the `!` divider. If the cached statement is false, exectue everthing after the `!` divider.

### Extension Syntax
`={3,3};(P{this is true,1}!P{this is false,1})`

Treat the first and second arguments as interpolated functions. Also note that this function uses parentheses instead of curly brackets.

# HTML Generator
Soup can generate a nice little webpage displaying your code outputs in the current directory called "SoupNoodle.html" Get it? Noodle soup? Soup's the name of the language? Yeah?

`H{title,description}`

# Running Soup
How to make and run a Soup file
1) Make a new file with the .soup extension
2) Write code in that file
3) Open up a new Windows command line window in the same directory
4) Type `soup {filename} {flags if you have them}` or `soup "{some soup code}"⁰`
*⁰ passing soup functions this way is only designed as a quick test; some functions might not work properly this way*

## Flags
Flag table

Flag | Function
-- | --
`-i` | prints the current index of the main loop (excludes loop functions)
`""` | pass soup code from within the quotations to execute some Soup code

# Important Things to Remember
- Sometimes you can't always do everything in one function, so break it up and store the results
- Soup doesn't like it when you have spaces between paramaters (or extra commas)
- Remember that variables can be interpolated with other functions, so use that to your advantage
- Don't use caps unless you are using a function
- Don't put soup function indentifiers inside of functions! Example `[{0,3}].P{Hello,1}` -> **THIS WILL CRASH**
