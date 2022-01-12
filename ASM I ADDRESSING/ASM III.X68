*-----------------------------------------------------------
* Title      :
* Written by :
* Date       :
* Description:
*-----------------------------------------------------------
    ORG    $1000
START:                  ; first instruction of program
        
         LEA text, A1 *loading the Address into an Address register*
         MOVE #4,D0   *Moves the value into the give address
         TRAP #15     *Asked to enter a number because theres nothing there
         MOVE #14,D0
         TRAP #15     
         MOVE #3,D0
         TRAP #15
* Put program code here

    SIMHALT             ; halt simulator
text dc.b 'Data Register: ',0 
* Put variables and constants here

    END    START        ; last line of source

*~Font name~Courier New~
*~Font size~10~
*~Tab type~1~
*~Tab size~4~
