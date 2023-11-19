package game.checkers.validator.basic

import adt.InvalidMovementResult
import adt.ResultMovement
import adt.SuccessfulMovementResult
import chessgame.movement.Movement
import chessgame.movement.Position
import game.chess.validator.LimitMovementValidator
import game.common.GameState
import game.common.validator.MovementValidator
import game.common.validator.basic.DiagonalMovementValidator
import game.common.validator.basic.FowardDiagonalMovementValidator
import game.common.validator.basic.ToPositionClearValidator
import game.common.validator.logic.AndMovementValidator

/**
 * @author Agustin Augurusa
 */
class NotObligatedToEatValidator : MovementValidator {
    private val eatDiagonalMvChecker = AndMovementValidator(
        listOf(
            LimitMovementValidator(2),
            InBetweenEnemyValidator(),
            ToPositionClearValidator(),
            FowardDiagonalMovementValidator()
        )
    )

    private val eatDiagonalMvCrowned = AndMovementValidator(
        listOf(
            LimitMovementValidator(2),
            InBetweenEnemyValidator(),
            ToPositionClearValidator(),
            DiagonalMovementValidator()
        )
    )

    private val basicCheckersValidator = BasicCheckersValidator()

    override fun validate(movement: Movement, gameState: GameState): ResultMovement {
        val pieceList = gameState.getPieceMap().filter { it.value.colour == gameState.getCurrentColour() }
        for ((piecePosition, piece) in pieceList) {
            for (i in 1..gameState.board.numCol) {
                for (j in 1..gameState.board.numRow) {
                    val toPosition = Position(i, j)
                    val newMovement = Movement(toPosition, piecePosition)
                    if (basicCheckersValidator.validate(newMovement, gameState) is SuccessfulMovementResult) {
                        if (piece.type == "PAWN") {
                            if (eatDiagonalMvChecker.validate(newMovement, gameState) is SuccessfulMovementResult) {
                                return InvalidMovementResult("You have to eat")
                            }
                        } else {
                            if (eatDiagonalMvCrowned.validate(newMovement, gameState) is SuccessfulMovementResult) {
                                return InvalidMovementResult("You have to eat")
                            }
                        }
                    }
                }
            }
        }
        return SuccessfulMovementResult()
    }
}