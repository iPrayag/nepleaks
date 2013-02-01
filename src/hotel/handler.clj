(ns hotel.handler
  (:use compojure.core
	hotel.views.post
        [hiccup.middleware :only (wrap-base-url)])
  (:require [compojure.handler :as handler]
            [compojure.route :as route]))

(comment
	define servlet app-routes
)
(defroutes app-routes
  (GET "/" [] (index))
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))

(comment
(run-server {:port 8080}
            "/*" (servlet app-routes))
)
