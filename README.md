
# handson-magic-cards-back

 1. Tive bastante problemas para montar o ambiente, por sempre usar windows e não linux deu algum trabalho. Criei uma vm e tive que instalar tudo o que precisava e rodei a aplicação por lá.
 2. A aplicação está funcional, tem que atentar aos campos **NOT NULL** da tabela senão dá um erro não tratado na inclusão e alteração.
 3. Em relação aos testes automáticos, como precisei subir uma base em memória hsqldb precisei formatar o script de criação das duas tabelas de acordo com o que ele aceitava. Como ele não aceita o tipo float e mudar ali teria impacto na entidade JPA no Hibernate se eu alterasse-a. Acabei excluindo os dois campos para não perder mais tempo tentando achar uma solução, vi que a aplicação nem referenciava esses campos, então achei que estaria ok.
 4. Ainda sobre os testes automáticos, na camada de controller eu estava mockando apenas as repositorys, para ter a chamada do serviço, mas por algum motivo no teste do serviço de delete o método *given()* do MockMvc não estava entendendo o *given(mockExpansionRepository.delete(expansion.getExpansionId()))* e sempre dava o problema de **"The method given(T) in the type BDDMockito is not applicable for the arguments (void)"**, acabei não seguindo o padrão dos outros por falta de tempo de entender também.
 5. Por algum motivo também que não consegui ver, mas o lombok responsável pela criação dos getters e setters não estavam criando nos testes automáticos. COmo os testes eu fiz no windows tudo estava ok e compilado, no linux não parei pra ver porque, mas deve ser alguma coisa de dependência e escopo de testes. (Apesar que o requisito era ter o ambiente linux, para os testes acabei fazendo no windows para evitar perder tempo com coisas de ambiente que me tomaria mais tempo do que eu tenho)
 As imagens estão no stc/test/resources dos testes verdes.
 
