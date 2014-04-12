(ns nepleaks.handler
  (:use compojure.core
	nepleaks.views.post
  nepleaks.templates
        [hiccup.middleware :only (wrap-base-url)])
  (:require [compojure.handler  :as handler]
            [compojure.route    :as route]
            [ring.util.response :as resp])
            )

(comment
	define servlet app-routes
)
(defroutes app-routes
  (GET "/" [] (index))

  ;; nepleaks users
  (GET "/leaker/list"     []   (tpl-leaker-list "prayag"))
  (GET "/leaker/edit/:id" [id] (str "<h3>Hi leaker" id "</h3>"))

  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))

(comment
(run-server {:port 8080}
            "/*" (servlet app-routes))
)
