{:user
 {:dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/tools.nrepl "0.2.12"]
                 [slamhound "1.5.5"]
                 [midje "1.8.3"]
                 [org.clojure/test.check "0.9.0"]
                 [clj-stacktrace "0.2.8"]
                 [criterium "0.4.4"]]
  :injections [(let [orig (ns-resolve (doto 'clojure.stacktrace require)
                                      'print-cause-trace)
                     new (ns-resolve (doto 'clj-stacktrace.repl require)
                                     'pst)]
                 (alter-var-root orig (constantly (deref new))))]
  :plugins [[cider/cider-nrepl "0.15.0-SNAPSHOT"]
            [lein-pprint "1.1.2"]
            [fipp "0.6.4"]
            [lein-kibit "0.1.3"]
            [lein-midje "3.2.1"]
            [lein-cloverage "1.0.9"]
            [lein-ancient "0.6.10"]]
  :aliases {"slamhound" ["run" "-m" "slam.hound"]}}}
