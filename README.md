SinglePath
==========

Can you get rid of all the IFs?

The game is: submit a snippet of code containing an ```if–else``` construct (or any other statements causing alternative paths of execution) 
and for which you believe the elimination of the conditional statement is impractical or too hard.
That is: a snippet of code that, in someone's opinion, *must* have an ```if-else```.

The goal is: collectively refactor the code, with the manifest and deliberate goal of eliminating the conditional path.

Then, reflect on the result. Was it worth the effort?


Rules
-----
Everyone can submit a snippet of code. Just open a pull request.
Use the language you prefer: Java, C#, Python, what ever you want.
Just provide enough tests in order to make your intents clear.


Run the tests
-------------

On *nix run

    gradle test

On Windows

    ./gradlew test 
