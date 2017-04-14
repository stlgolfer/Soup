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
`!` | Adding
`@` | Subtracting
`#` | Multiply
`$` | Divide
`%` | Raise to the Power Of
`^` | Logarithm (Exponent#Base)
`&` | Print (e = 1 print, 0 for println)

# Triple Paramater Functions
These are functions that take three paramaters

Token | Operation | Notes
----- | ----- | -----
`*` | Quadratic {aterm,bterm,cterm} | Returns NaN if calculation is nonreal

# Variable Storage
Please note that you must store variables sequentially. For example, you cannot store a variable in index 0 and then store another one in index 4; you must then store in index 1. Also, you cannot print after retrieving a variable (it's a bug)

Token | Operation | Example
---- | ---- | -----
`:` | Stores the last operation's output in the specific index (excluding print) | `!{5,5}:{0}`
`v` | Retrieves a variable | `v{0}`

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

# Import things to know
- With the new structure of parsefunc, you can't have a Soup token inside a print function
- Soup doesn't like it when you have spaces between paramaters
