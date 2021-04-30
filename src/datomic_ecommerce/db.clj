(ns datomic-ecommerce.db
  (:use clojure.pprint)
  (:require [datomic.api :as d])
  )

(def db-uri "datomic:dev://localhost:4334/hello")

(defn abre-conexao []
  (d/create-database db-uri)
  (d/connect db-uri)
  )

(defn apaga-banco []
  (d/delete-database db-uri)
  )

;Produtos
;id?
;nome String 1==> Computaor novo
;slug String 1 ==> /computador_novo
;preço ponto flutuante 1

;id_entidade atributo valor
;15 nome Computaor novo
;15 slug /computador_novo
;15 preço 3500.10

(def schema [{
              :db/iden :produto/nome
              :db/valueType :db.type/string
              :db/cardinality :db.cardinality/one
              :db/doc "o nome de um produto"
              }
             {
              :db/iden :produto/slug
              :db/valueType :db.type/string
              :db/cardinality :db.cardinality/one
              :db/doc "o caminho para acessar esse prod via http"
              }
             {
              :db/iden :produto/preco
              :db/valueType :db.type/bigdec
              :db/cardinality :db.cardinality/one
              :db/doc "o preço do produto"
              }])

(defn cria-schema [conn]
  (d/transact conn schema)
  )