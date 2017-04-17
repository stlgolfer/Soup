# Soup
*A Java Interpreted Langauge*

# Basic Syntax
For most double paramater operations, this is the syntax

`i{f,e}`

where 

Token | Description
---- | ---
i | the indentifier
f | first paramater
e | second paramater

# Basic Functions (Poly-Argument Functions)
Soup can do these basic math functions along with other functions. Functions will continuously calculate the arguments left to right.

Example

`+{4,5,5}` -> `14`
`%{12,2,2}` -> `3` (12/2 -> 6, 6/2 -> 3)

Key: italics denotes that the function only takes one argument

Token | Operation
----- | -----
`+` | Adding
`-` | Subtracting
`*` | Multiply
`%` | Divide
`^` | Raise to the Power Of (base,exponent)
`#` | Logarithm (exponent,base)
`p` | Print (e = 1 print, e = 0 for print line)
`{pipe}` | Absolute Value of single number
`&` | *Square Root*
`?` | *Rounds the number*
`~` | Stores a variable at a specific index `~{3,0} // number 3 at index 0`
`/` | Comments (jumps index to the end of the line)
` ` | Only a single space between functions is permitted (it's proper to use a period, though)

# Triple Paramater Functions (Static Arguments)
These are functions that take three paramaters

Token | Operation | Notes
----- | ----- | -----
`@` | Quadratic {aterm,bterm,cterm} | Returns NaN if calculation is nonreal

# Variable Storage
Please note that you must store variables sequentially. For example, you cannot store a variable in index 0 and then store another one in index 4; you must then store in index 1. Also, you cannot print after retrieving a variable (it's a bug)

Token | Operation | Example
---- | ---- | -----
`:` | Stores the last operation's output in the specific index (excluding print) | `!{5,5}:{0}`

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

# Variable Retrieval
## Explicit Recalling
Variables can be called from within functions or just printed to the screen

If you want to just recall a variable:

`v{0}`

where 0 is the index that you want to pull from.

## Interpolated Recalling
Variables can be recalled from within functions for interpolation and manipulation

For example:

```
~{3,0} // stores '3' in index 0
+{v0,3} // v will substitute the recalled variable at index 0 and add it with 3 to get the answer
```

# Variable Storing
Very important notes:
1. Most functions will add cache their output
2. Variables **Must be stored seqentially**. For example, you can't store a variable in index 0 and then index 5
3. Each output **must** have their own index (variables cannot be overwritten)
4. Variable storing gets

# Getting User Input
In Soup, you can accept the user's input and store it like this:

` i{What's the number?,0} `

The first paramater is the string and the second paramater is the index where the input will be stored

# Miscellaneous Characters
These are characters that have some special functions

Token | Operation | Notes
------- | --------
`[` | Evaluates two single-digits
`.` | End of function | it's like a semicolon, it's not necessary but it's there for making code easier to read

# Important Things to Remember
- Sometimes you can't always do everything in one function, so break it up and store the results
- Soup doesn't like it when you have spaces between paramaters
- remember that variables can be interpolated with other functions, so use that to your advantage
