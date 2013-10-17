(ns com.semperos.sp.macros)

(defmacro log [& body]
  `(.log js/console ~@body))
