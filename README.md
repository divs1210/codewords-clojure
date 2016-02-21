# codewords-clojure

Demo app for the codewords presentation for Red Panda.

## Development Mode

### Without CIDER *(Basic)*:

```
lein clean
lein figwheel dev
```

Wait a bit, then browse to [http://localhost:3449](http://localhost:3449).
Figwheel will push changes in cljs files to the browser when saved.

### With CIDER *(Advanced)*:

* Open `src/cljs/codewords/views.cljs` and run `C-c M-j` to launch an nREPL session
* Evaluate `(use 'codewords.repl)` in the REPL
* Wait a bit, then point your browser to [http://localhost:3449](http://localhost:3449)
* In the `.cljs` file, run `C-c M-n` so the REPL points to the current ns
* Hack away!

## Production Build

```
lein clean
lein cljsbuild once min
```
