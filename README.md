# pong-hau-ki
---

Trabalhado desenvolvido à aula de Inteligencia Artificial da Universidade de Joinville - Univille.


Regras do jogo:
  * fazer com que seu oponente não consiga mais se mover.

![ponghauki](https://catracalivre.com.br/wp-content/uploads/sites/10/2018/04/jogo_de_raciocinio_tempojunto_02.jpg)


Lógica aplicada no código:
  o jogo pong hau ki tem 5 pontos, sendo dois esquerdos, dois direitos e um no centro. tendo passagem apenas entre os pontos menos nos dois pontos lateriais da parte de cima.
  visando isso, a logica se baseia sempre em tentar mudar o campo superior para o centro e caso não de, sempre voltar para seu "campo" ou seja, onde as peças iniciaram, também, tenta pegar o melhor lugar quando há mais de um passo para dar visando sempre mover de cima para o meio para que prenda o oponente.
