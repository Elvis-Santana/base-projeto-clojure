(ns base-projeto-clojure.bot)


;; 1. ESTADO: Um átomo para guardar o estado ou contexto de cada usuário
; (def historico-usuarios (atom {}))
;; 
;; 2. REGRAS: Suas regras funcionais de tomada de decisão (Sua especialidade!)
;; (defn processar-mensagem
;;   [usuario-id mensagem]
;;   (let [mensagem-limpa (clojure.string/lower-case (clojure.string/trim mensagem))
;;         etapa-atual (get-in @historico-usuarios [usuario-id :etapa] :inicio)]
;; 
;;     (cond
;;       (= mensagem-limpa "sair")
;;       (do
;;         (swap! historico-usuarios dissoc usuario-id) ; Limpa o histórico do usuário
;;         "Atendimento encerrado. Até logo!")
;; 
;;       (= etapa-atual :inicio)
;;       (do
;;         (swap! historico-usuarios assoc-in [usuario-id :etapa] :aguardando-nome)
;;         "Olá! Sou o assistente Clojure. Qual é o seu nome?")
;; 
;;       (= etapa-atual :aguardando-nome)
;;       (do
;;         (swap! historico-usuarios assoc-in [usuario-id :nome] mensagem)
;;         (swap! historico-usuarios assoc-in [usuario-id :etapa] :finalizado)
;;         (str "Prazer em te conhecer, " mensagem "! Como posso te ajudar hoje?"))
;; 
;;       :else
;;       "Desculpe, não entendi. Digite 'sair' para recomeçar.")))
;; 
;; ;; Primeira mensagem do usuário (Ativa o estado :inicio)
;; (println (processar-mensagem 123 "Oi, quero iniciar"))
;; ;; Retorno no terminal: "Olá! Sou o assistente Clojure. Qual é o seu nome?"
;; 
;; ;; Segunda mensagem do usuário (Ele responde o nome dele)
;; (println (processar-mensagem 123 "Carlos"))
;; ;; Retorno no terminal: "Prazer em te conhecer, Carlos! Como posso te ajudar hoje?"
;; 
;; ;; Terceira mensagem do usuário (O bot cai no :else pois já está na etapa :finalizado)
;; (println (processar-mensagem 123 "Qual a previsão do tempo?"))
;; ;; Retorno no terminal: "Desculpe, não entendi. Digite 'sair' para recomeçar."
;; 
;; ;; Quarta mensagem (Reseta o estado limpando o ID do usuário do átomo)
;; (println (processar-mensagem 123 "sair"))
;; Retorno no terminal: "Atendimento encerrado. Até logo!"

(def v 0.2)