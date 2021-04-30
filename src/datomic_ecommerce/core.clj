(ns datomic-ecommerce.core
  (:use clojure.pprint)
  (:require
    [datomic.api :as d]
    [datomic-ecommerce.db :as db]
    [datomic-ecommerce.model :as model]))

(def conn (db/abre-conexao))
(pprint conn)

(db/cria-schema conn)

;tem que por M no final de bigdecimals
(let [computador (model/novo-produto "Computador Novo", "/computador_novo", 2500.10M)]
  (d/transact conn [computador]))











;import lib
;(require [datomic.api :as d])
;define the db url
;(def db-uri "datomic:dev://localhost:4334/hello")
;create the db
;(d/create-database db-uri)