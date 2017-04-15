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

# Basic Double Paramater Functions
Currently, Soup can do only basic math functions such as adding and subtracting, but more will be added in the future

Token | Operation
----- | -----
`+` | Adding
`-` | Subtracting
`*` | Multiply
`%` | Divide
`^` | Raise to the Power Of
`#` | Logarithm (Exponent#Base)
`p` | Print (e = 1 print, e = 0 for print line)
`{pipe}` | Absolute Value of single number
`?` | Rounds the number
`~` | Stores a variable at a specific index `~{3,0} // number 3 at index 0`
`/` | Comments (jumps index to the end of the line)
` ` | Only a single space between functions is permitted (it's proper to use a period, though)

# Triple Paramater Functions
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

## Regular Functions
`${f,e}`

where

`f` Case | `e` Function
------ | -------
`s` | Sine of number
`c` | Cosine of number
`t` | Tangent of number

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

# Getting User Input
In Soup, you can accept the user's input and store it like this:

` i{What's the number?,0} `

The first paramater is the string and the second paramater is the index where the input will be stored

# Miscellaneous Characters
These are characters that have some special functions

Token | Operation
------- | --------
`[` | Evaluates two single-digits
`.` | Doesn't get parsed (it's like a semicolon)

# Important things to know
- Sometimes you can't always do everything in one function, so break it up and store the results
- Soup doesn't like it when you have spaces between paramaters
- remember that variables can be interpolated with other functions, so use that to your advantage
