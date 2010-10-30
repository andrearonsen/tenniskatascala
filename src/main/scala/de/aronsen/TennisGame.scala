package de.aronsen

class TennisGame(player1: Player, player2: Player) {
  def winBallPlayer1 = calculateScores(player1, player2)

  def winBallPlayer2 = calculateScores(player2, player1)

  def calculateScores(winner: Player, looser: Player) = winner.score match {
    case "0" => winner.score = "15"
    case "15" => winner.score = "30"
    case "30" => {
      if (looser.score == "40") {
        winner.score = "DEUCE"
        looser.score = "DEUCE"
      } else {
        winner.score = "40"
      }
    }
    case "40" => {
      winner.score = "WIN"
      looser.score = "LOOSE"
    }
    case "DEUCE" => {
      if (winner.advantage) {
        winner.score = "WIN"
        looser.score = "LOOSE"
      } else if (looser.advantage) {
        looser.advantage = false
      } else {
        winner.advantage = true
      }
    }
  }

}