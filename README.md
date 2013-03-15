ideah
------------

ideah is a [Haskell][1] language support plugin for [IntelliJ IDEA][2].

**NOTE**: ideah used to live exclusively on [Google Code][6], but **PLEASE
CONTRIBUTE TO THE LATEST CODE HERE ON GITHUB**.  I'll work with Oleg and
Marianna, the original authors of ideah, to deprecate Google Code. Binary
releases are still hosted on Google Code at the moment.


### Getting started

To work with the plugin, you'll need:
*  [IntelliJ IDEA 10.x or 11.x][5]. 12.x is **NOT SUPPORTED**
*  [GHC][7] (Glasgow Haskell Compiler). You can get this by installing the [Haskell Platform][13]
*  [Haskell Cabal][17] if you decided not to install Haskell Platform

All future releases will support IDEA 11.x exclusively. 10.x will not be supported.
We are working towards 12.x support.


### Current

We are happy to announce the first release! Please [report][3] bugs.

ideah supports:

*   Syntax highlighting
*   Compiling and running
*   Error and warning highlighting
*   Identifier module and type lookup
*   Comment code
*   Easy to setup
*   Documentation lookup
*   Find usages
*   Go to function declaration
*   GHCi integration

### Coming Soon

We are working on:

*   IntelliJ IDEA 12.x support
*   Hlint integration
*   Refactoring (rename and safe delete)
*   Program structure view
*   Identifer documentation and type lookup for standard/external modules

### Under Discussion

Our future plans:

*   Code formatting
*   Code autocompletion
*   Complex refactoring
*   Code intentions

Please [let us know][8] what features would be most helpful to you.

See the [wiki][9] guides for [installation][10], [configuration][11] and [usage][12].

## January 23, 2012

Versions [0.2][14] for IDEA 10.x and [0.2.11][15] for 11.x have been released.

What's new:

*   Mac OSX integration. Many thanks to [jsinglet][16]!
*   Documentation lookup
*   Find usages
*   Go to function declaration
*   GHCi integration
*   Improved Compile/Run customization

## September 29, 2011

First version [0.1][18] released, still in Beta.

Supports:

*   Syntax highlighting
*   Compiling and running
*   Error and warning highlighting
*   Identifier module and type lookup
*   Comment code

## Contributors

ideah was developed by Oleg Sobolev and Marianna Rapoport (@amaurremi).
I (@fushunpoon) moved the project sources, issues and wiki over to GitHub from Google Code.

 [1]: http://www.haskell.org/haskellwiki/Haskell
 [2]: http://www.jetbrains.com/idea/
 [3]: https://github.com/fushunpoon/ideah/issues/new
 [4]: http://www.jetbrains.com/idea/download/index.html
 [5]: http://devnet.jetbrains.com/docs/DOC-1228
 [6]: https://code.google.com/p/ideah
 [7]: http://www.haskell.org/ghc/download
 [8]: mailto:ideah.plugin@gmail.com?subject=Features
 [9]: http://code.google.com/p/ideah/w/list
 [10]: https://github.com/fushunpoon/ideah/wiki/Installing-ideah
 [11]: https://github.com/fushunpoon/ideah/wiki/Installing-ideah#Creating_Haskell_Project
 [12]: https://github.com/fushunpoon/ideah/wiki/Using-ideah
 [13]: http://www.haskell.org/platform/
 [14]: http://code.google.com/p/ideah/downloads/detail?name=ideah-bin-0.2.zip
 [15]: http://code.google.com/p/ideah/downloads/detail?name=ideah-bin-0.2.11.zip
 [16]: http://code.google.com/u/110309710902971481338/
 [17]: http://www.haskell.org/cabal
 [18]: http://code.google.com/p/ideah/downloads/detail?name=ideah-bin-0.1.zip&can=1&q=
