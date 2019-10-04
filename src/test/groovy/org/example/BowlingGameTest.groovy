/*
 * This Spock specification was generated by the Gradle 'init' task.
 */
package org.example

import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

class BowlingGameTest extends Specification {

    @Subject
    BowlingGame game

    def setup() {
        game = new BowlingGame()
    }

    @Unroll
    def "scorecard #scorecard has score #score"() {
        expect:
        game.roll scorecard
        game.score == score

        where:
        scorecard                                                   | score
        [0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0] as int[] | 0
        [0,1, 0,1, 0,1, 0,1, 0,1, 0,1, 0,1, 0,1, 0,1, 0,1] as int[] | 10
        [1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1] as int[] | 20
        [1,2, 1,2, 1,2, 1,2, 1,2, 1,2, 1,2, 1,2, 1,2, 1,2] as int[] | 30
        [2,2, 2,2, 2,2, 2,2, 2,2, 2,2, 2,2, 2,2, 2,2, 2,2] as int[] | 40
        [10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10] as int[]   | 300
    }


    def "spare followed by 3 then all gutters should have 16 score"() {
        when:
        def scorecard = [5,5, 3,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0] as int[]
        game.roll scorecard

        then:
        game.score == 16
    }

    def "strike followed by 3,3 then all gutters should have 22 score"() {
        when:
        def scorecard = [10, 3,3, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0] as int[]
        game.roll scorecard

        then:
        game.score == 22
    }
}
