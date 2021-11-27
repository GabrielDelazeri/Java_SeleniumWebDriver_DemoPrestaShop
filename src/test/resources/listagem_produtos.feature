#language: pt
  Funcionalidade: Listagem de produtos disponíveis para compra
    Como um usuário não logado
    Eu quero visualizar os produtos cadastrados
    Para poder escolher qual produto vou comprar

  Cenário: Mostra pelo menos um produto na tela inicial
    Dado que estou na página inicial
    Quando não estou logado
    Então visualizo o produto de nome "Hummingbird Printed T-Shirt" na posição "1"
