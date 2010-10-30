package de.aronsen

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class TennisGameSpec extends FlatSpec with ShouldMatchers {
  val player1 = new Player
  val player2 = new Player
  val tennisGame = new TennisGame(player1, player2)

  it should "return score 0 for player1 at start" in {player1.score should equal("0")}
  it should "return score 0 for player2 at start" in {player2.score should equal("0")}
  it should "return score 15 for player1 after winning ball" in {tennisGame.winBallPlayer1; player1.score should equal("15")}
  it should "return score 30 for player1 after winning ball again" in {tennisGame.winBallPlayer1; player1.score should equal("30")}
  it should "return score 40 for player1 after winning ball again" in {tennisGame.winBallPlayer1; player1.score should equal("40")}
  it should "return score 15 for player2 after winning ball" in {tennisGame.winBallPlayer2; player2.score should equal("15")}
  it should "return score 30 for player2 after winning ball again" in {tennisGame.winBallPlayer2; player2.score should equal("30")}
  it should "return score DEUCE for player2 after winning ball again" in {tennisGame.winBallPlayer2; player2.score should equal("DEUCE")}
  it should "return advantage for player1 after winning ball" in {tennisGame.winBallPlayer1; player1.advantage should equal(true)}
  it should "return no advantage for player1 after player2 wins the ball" in {tennisGame.winBallPlayer2; player1.advantage should equal(false)}
  it should "return advantage for player2 after winning the ball" in {tennisGame.winBallPlayer2; player2.advantage should equal(true)}
  it should "return WIN for player2 after winning the ball" in {tennisGame.winBallPlayer2; player2.score should equal("WIN")}

}