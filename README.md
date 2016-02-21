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

* Browse to `src/clj/codewords/user.clj` and run `C-x M-j` to connect to nREPL
* Run `C-c M-n` to switch REPL to `codewords.user` ns
* Run `C-c C-k` to compile and evaluate the ns, thus starting figwheel (give it a sec)
* Evaluate `(cljs-repl)` in the REPL
* Wait a bit, then point your browser to [http://localhost:3449](http://localhost:3449)
* Browse to `src/cljs/codewords/views.cljs` and run `C-c M-n` to switch to this ns
* Hack away!

## Production Build

```
lein clean
lein cljsbuild once min
```
