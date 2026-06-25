(ns base-projeto-clojure.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))


(def desc 0.1)


(def carinho [{:produto "carro" :preco 1000}
              {:produto "moto" :preco 100}
              {:produto "pão" :preco 10}])


(defn MAPA
  [lista desconto]
  (map (fn [{:keys [produto preco]}]
         {:produto produto
          :preco (- preco (* desconto preco))})
       lista))



(defn fatura [lista desconto]
  (let [i (MAPA lista desconto)]
    (doseq [{:keys [produto preco]} i]
      (println  produto  "$RS" preco))
    (println "valor final = " (reduce + (map  :preco i)))))


;;(get  :preco objeto)
;; (map  :preco lista de objeto)
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
        "Cadastro Ativo")
      (do
        (println "Erro: Usuário")
        "Cadastro Recusado"))))
