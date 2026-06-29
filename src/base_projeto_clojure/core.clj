(ns base-projeto-clojure.core
  (:gen-class)
  (:require [clojure.string :as str]
            [base-projeto-clojure.bot :refer [v]]
            [clojure.pprint :as cp]
            [clojure.java.javadoc :as jdoc]
            [clojure.inspector :as insp]
            [clojure.spec.alpha :as s]))

;; Abre a janela gráfica para inspecionar o mapa
(defn testar-inspector []
  (let [dados-do-bot {:status "online"
                      :usuarios [{:id 1 :nome "Carlos"} {:id 2 :nome "Ana"}]}]
    (insp/inspect dados-do-bot)))

;; 1. Avalie estas linhas primeiro!
(s/def ::id int?)
(s/def ::nome string?)
(s/def ::usuario (s/keys :req [::id ::nome]
                         :opt [::email]))

;; 2. Só depois avalie ou execute isto:
(defn testar-spec []
  (s/valid? ::usuario {::id 1 ::nome "Bot" ::email "add"}))



(defn inspecionar-tudo
  [dados]
  (insp/inspect-tree dados))

(def desc 0.1)


(def carinho [{:produto "carro" :preco 1000}
              {:produto "moto" :preco 100}
              {:produto "pão" :preco 10}])



(defn va[isV]   (if (not-empty isV)
 "não vazio"
 "vazio"))

;; (defn MAPA
;;   [lista desconto]
;;   (map (fn [{:keys [produto preco]}]
;;          {:produto produto
;;           :preco (- preco (* desconto preco))})
;;        lista))
;; 
;; 
;; (defn fatura [lista desconto]
;;   (let [i (MAPA lista desconto)]
;;     (doseq [{:keys [produto preco]} i]
;;       (println  produto  "$RS" preco))
;;     (println "valor final = " (reduce + (map  :preco i)))))



(defn fatura [lista desconto]
  (->> lista
       (map #(assoc % :preco (- (:preco %) (* desconto (:preco %)))))
       (run! #(println (:produto %) "$RS" (:preco %)))))

;;run!
;;(get  :preco objeto)
;; (map  :preco (lista de objeto))
;; (get usuario :nome)
;; #(>= % 18)




(defn validar
  [data command messagem]
  (let [value (command data)]
    (if (not value)
      (do
        (println messagem)
        false)
      true)))

(def erro-mais-18  #(>= % 18))
(def erro-min-name  #(>= (count %) 3))

(def msg-mais-18 "menores de 18 são invalidos")
(def msg-min-name "o minimo de 3 caracteres")

(defn cads []
  (let [_ (println "idade:")
        idade (Integer/parseInt (read-line))
        _ (println "name:")
        name (read-line)]

    (if (and (validar idade erro-mais-18 msg-mais-18)
             (validar name erro-min-name msg-min-name))
      (do
        (println "Acesso liberado no sistema.")
        "Cadastro Ativ")
      (do
        (println "Erro: Usuário")
        "Cadastro Recusado"))))

;; - método publico e estatico
(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "-main" args))

;; ESTRUTURA MAPA => {:name "nanico"}
(defn processar-usuario [{:keys [nome] :as mapa-completo}]
  (println "Olá," nome)
  (println "Salvando no banco todo o conteúdo:" mapa-completo))

(def lista-literal  '(+ 1 2))  ;; Retorna (+ 1 2)

;; (let [usuario {:nome "ana" :idade 25}]
;;   (clojure.string/upper-case (assoc usuario :nome "ana silva")))
;; Lê-se de dentro para fora: associa o nome e depois transforma em maiúsculo (vai falhar porque upper-case espera string, não mapa

;; (-> {:nome "ana" :idade 25}
;;     (assoc :nome "pedro")      ;; O mapa entra como 1º argumento aqui
;;     :nome                      ;; Abreviação para pegar a chave :nome do mapa resultante
;;     (clojure.string/upper-case))

;; (-> {:nome "carlos" :idade 20}
;;     (assoc :ativo true)       ;; Vira: (assoc {:nome...} :ativo true)
;;     (update :nome clojure.string/upper-case)
;;     (dissoc :idade))