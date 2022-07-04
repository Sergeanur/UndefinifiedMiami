MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// ****************************		Assin1 - Job 'Road Kill'	  **************************
// *********Carl Pearson, delivery man.  He must not complete his deliveries.***************
// *********blip on radar for bloke driving a van. Player must kill him before he completes* 
// *********deliveries. Set car to wander randomly, then after a set time, set car to goto** 
// *********coordinates. If he reaches location successfully, mission fails***************** 
// ******************************(discuss mechanics of this?).******************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
{
SCRIPT_NAME assin1

// Mission start stuff
GOSUB mission_start_assin1

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_assin1_failed
ENDIF

GOSUB mission_cleanup_assin1

MISSION_END
 
// Variables for mission
VAR_INT carlpearson delvan carlblip countdown vanblip 

VAR_FLOAT delvanstartx delvanstarty delvanstartz delvanheading

//flags
VAR_INT got_out_of_car_flag delivery_status pizza_been_thrown mission_assin1_started

//pizza stuff
VAR_FLOAT pizza_lobx_a1 pizza_loby_a1 delvan_speed carlpearson_facing_this_direction
VAR_INT pizza_box_var_a1  


// **************************************** Mission Start **********************************

mission_start_assin1:				  

REGISTER_MISSION_GIVEN

flag_player_on_mission = 1

WAIT 0

LOAD_MISSION_TEXT ASSIN1  

REQUEST_MODEL pizzaboy
REQUEST_MODEL HMYRI
REQUEST_MODEL pizzabox
REQUEST_MODEL cellphone

WHILE NOT HAS_MODEL_LOADED pizzaboy
	OR NOT HAS_MODEL_LOADED HMYRI
	OR NOT HAS_MODEL_LOADED pizzabox
	OR NOT HAS_MODEL_LOADED cellphone
WAIT 0
ENDWHILE

///////////////////////////////////////////////////////////////////////////////////////cutscene
DO_FADE 1500 FADE_IN

SET_PED_DENSITY_MULTIPLIER 0.0
SET_CAR_DENSITY_MULTIPLIER 0.0

CLEAR_AREA 37.6088 -1023.9865 9.4108 1.0 FALSE
CLEAR_AREA 36.868168 -1027.186523 10.417089 1.0 FALSE

CLEAR_AREA_OF_CHARS 14.0 -1034.703 5.02 69.44 -1008.6639 14.0

SWITCH_WIDESCREEN ON
		  
SET_PLAYER_COORDINATES player1 36.8778 -1023.9880 9.4108 
SET_PLAYER_HEADING player1 -0.01

SET_FIXED_CAMERA_POSITION 36.868168 -1027.186523 10.417089 0.0 0.0 0.0
POINT_CAMERA_AT_PLAYER player1 FOLLOWPED JUMP_CUT
SET_CAMERA_BEHIND_PLAYER
SET_CHAR_ANSWERING_MOBILE scplayer TRUE

LOAD_MISSION_AUDIO 1 JOB1_1b
LOAD_MISSION_AUDIO 2 JOB1_1c

WHILE NOT HAS_MISSION_AUDIO_LOADED 1
	OR NOT HAS_MISSION_AUDIO_LOADED 2
	WAIT 0
ENDWHILE 

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

PRINT_NOW ( ASM1_D ) 10000 1 
PLAY_MISSION_AUDIO 1
WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
AND NOT IS_CHAR_DEAD scplayer
	WAIT 0
	IF IS_BUTTON_PRESSED PAD1 cross
		GOTO endasm1cs
	ENDIF
ENDWHILE
CLEAR_THIS_PRINT ASM1_D
CLEAR_MISSION_AUDIO 1


PRINT_NOW ( ASM1_C ) 10000 1 
PLAY_MISSION_AUDIO 2
WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
AND NOT IS_CHAR_DEAD scplayer
	WAIT 0
	IF IS_BUTTON_PRESSED PAD1 cross
		GOTO endasm1cs
	ENDIF
ENDWHILE
CLEAR_THIS_PRINT ASM1_C
CLEAR_MISSION_AUDIO 2

LOAD_MISSION_AUDIO 1 JOB1_1d

WHILE NOT HAS_MISSION_AUDIO_LOADED 1
	WAIT 0
ENDWHILE 

PRINT_NOW ( ASM1_B ) 10000 1 
PLAY_MISSION_AUDIO 1
WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
AND NOT IS_CHAR_DEAD scplayer
	WAIT 0
	IF IS_BUTTON_PRESSED PAD1 cross
		GOTO endasm1cs
	ENDIF
ENDWHILE
CLEAR_THIS_PRINT ASM1_B
CLEAR_MISSION_AUDIO 1


endasm1cs:

CLEAR_MISSION_AUDIO 1
CLEAR_MISSION_AUDIO 2
CLEAR_SMALL_PRINTS

WAIT 500

SET_CHAR_ANSWERING_MOBILE scplayer FALSE
MARK_MODEL_AS_NO_LONGER_NEEDED cellphone

DO_FADE 1500 FADE_OUT


SET_PED_DENSITY_MULTIPLIER 1.0
SET_CAR_DENSITY_MULTIPLIER 1.0

TIMERA = 0 

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

SWITCH_WIDESCREEN OFF
RESTORE_CAMERA_JUMPCUT
SET_CAMERA_BEHIND_PLAYER

DO_FADE 1500 FADE_IN

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE


SET_PLAYER_CONTROL player1 ON



//////////////////////////////////////////////////////////////////////////////////////


//Delivery vans starting point
delvanstartx = 121.0519
delvanstarty = -1443.547
delvanstartz = 9.845
delvanheading = 150.0

//flags
got_out_of_car_flag = 0
mission_assin1_started = 0
pizza_been_thrown = 0
delivery_status = 50

SET_ENTER_CAR_RANGE_MULTIPLIER 3.0





 



assin1_loop:

WAIT 0
  
//start the actual mission
IF mission_assin1_started = 0
	
	PRINT_NOW ( ASM1_7 ) 10000 2
	mission_assin1_started = 2
	
	SET_PLAYER_MOOD player1 PLAYER_MOOD_ANGRY 350000

	//bar
	DISPLAY_ONSCREEN_COUNTER_WITH_STRING delivery_status COUNTER_DISPLAY_NUMBER ( ASM1_6 )

	CLEAR_AREA delvanstartx delvanstarty delvanstartz 5.0 FALSE
	//Create Carl Pearsons delivery van 
	CREATE_CAR pizzaboy delvanstartx delvanstarty delvanstartz delvan
	SET_CAR_HEADING delvan delvanheading
	//Put Carl inside this van
	CREATE_CHAR_INSIDE_CAR delvan PEDTYPE_CIVMALE HMYRI carlpearson

	
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER carlpearson TRUE
	ADD_ARMOUR_TO_CHAR carlpearson 50
	//Driving behaviour
	CAR_WANDER_RANDOMLY delvan
	SET_CAR_CRUISE_SPEED delvan 32.0
	SET_CAR_DRIVING_STYLE delvan DRIVINGMODE_AVOIDCARS
	SET_CAR_ONLY_DAMAGED_BY_PLAYER delvan TRUE
	
	//Give his car a blip
	ADD_BLIP_FOR_CHAR carlpearson carlblip
	
	mission_assin1_started = 1
ENDIF




IF mission_assin1_started = 1 

	//mission passed
	IF IS_CHAR_DEAD carlpearson
		GOTO mission_assin1_passed
	ENDIF

	//mission failed
	IF NOT IS_CHAR_DEAD carlpearson
		IF delivery_status = 0//PRINT NOW he made his deliveries!!!!!!!!!!!!
			CLEAR_ONSCREEN_COUNTER delivery_status
			PRINT_NOW ( ASM1_5 ) 5000 1
			GOTO mission_assin1_failed
		ENDIF
 	ENDIF
 	
 	   
	IF NOT IS_CHAR_DEAD carlpearson
		IF got_out_of_car_flag < 2
			 	IF NOT IS_CAR_DEAD delvan
			 		IF NOT IS_PLAYER_IN_CAR player1 delvan
						IF IS_CAR_IN_WATER delvan
							got_out_of_car_flag = 2
						ENDIF	
			 		ELSE
						got_out_of_car_flag = 2
			 		ENDIF
				ELSE
					got_out_of_car_flag = 2
				ENDIF
		ENDIF

		IF got_out_of_car_flag = 0
			IF NOT IS_CHAR_IN_ANY_CAR carlpearson
	 			SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER carlpearson delvan
 				SET_CHAR_RUNNING carlpearson TRUE
 				got_out_of_car_flag = 1
			ENDIF
		ENDIF
		

		IF got_out_of_car_flag = 1
			IF IS_CHAR_SITTING_IN_CAR carlpearson delvan
				SET_CAR_CRUISE_SPEED delvan 32.0
				SET_CAR_DRIVING_STYLE delvan DRIVINGMODE_AVOIDCARS
				CAR_WANDER_RANDOMLY	delvan
				got_out_of_car_flag = 0
			ENDIF
		ENDIF


		IF got_out_of_car_flag = 2
			IF IS_CHAR_ON_FOOT carlpearson
			OR IS_CAR_DEAD delvan
				SET_CHAR_OBJ_NO_OBJ carlpearson
				SET_CHAR_OBJ_FLEE_PLAYER_ON_FOOT_ALWAYS carlpearson player1
				got_out_of_car_flag = 3
			ELSE
				IF IS_CHAR_SITTING_IN_ANY_CAR carlpearson	
					SET_CHAR_OBJ_LEAVE_ANY_CAR carlpearson
				ENDIF
			ENDIF
		ENDIF



	ENDIF


  	IF pizza_been_thrown = 0
		IF NOT IS_CAR_DEAD delvan
			IF NOT IS_CHAR_DEAD carlpearson
				IF IS_CHAR_SITTING_IN_CAR carlpearson delvan 				   
					GET_CAR_SPEED delvan delvan_speed
						IF delvan_speed > 10.0
							CREATE_OBJECT_NO_OFFSET pizzabox 0.0 0.0 100.0 pizza_box_var_a1   
							PLACE_OBJECT_RELATIVE_TO_CAR pizza_box_var_a1 delvan 0.5 0.0 0.7
						  	SET_OBJECT_COLLISION pizza_box_var_a1 TRUE 	  
						  	SET_OBJECT_DYNAMIC pizza_box_var_a1 TRUE
						  	GET_CHAR_HEADING carlpearson carlpearson_facing_this_direction 
						  	pizza_lobx_a1 -= 90.0
							pizza_loby_a1 -= 90.0
						  	COS carlpearson_facing_this_direction pizza_lobx_a1  
						  	SIN carlpearson_facing_this_direction pizza_loby_a1 
						  	pizza_lobx_a1 *= 11.0 	 //change this to increase power of toss
							pizza_loby_a1 *= 11.0	 
						  	ADD_TO_OBJECT_VELOCITY pizza_box_var_a1 pizza_lobx_a1 pizza_loby_a1 6.0
						  	pizza_been_thrown = 1
							TIMERA = 0
						ENDIF
				ENDIF
			ENDIF
		ENDIF
  	ENDIF


	IF pizza_been_thrown = 1
		IF TIMERA > 5000
			DELETE_OBJECT pizza_box_var_a1
			delivery_status = delivery_status - 1
			pizza_been_thrown = 0
		ENDIF
	ENDIF
			



   
ENDIF



GOTO assin1_loop


 // **************************************** Mission haitian3 failed ************************

mission_assin1_failed:
PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed"
RETURN

   

// **************************************** mission haitian3 passed ************************

mission_assin1_passed:

flag_assin_mission1_passed = 1
REGISTER_MISSION_PASSED ( JOB_1 )
PRINT_WITH_NUMBER_BIG ( M_PASS ) 500 5000 1 //"Mission Passed!"
PLAY_MISSION_PASSED_TUNE 1 
CLEAR_WANTED_LEVEL player1
PLAYER_MADE_PROGRESS 1
ADD_NUMBER_OF_ASSASSINATIONS 1
ADD_SCORE player1 500
REMOVE_BLIP assasin_contact_blip
RETURN
		

// ********************************** mission cleanup **************************************

mission_cleanup_assin1:

flag_player_on_mission = 0
MARK_MODEL_AS_NO_LONGER_NEEDED pizzabox 
MARK_MODEL_AS_NO_LONGER_NEEDED HMYRI
MARK_MODEL_AS_NO_LONGER_NEEDED pizzaboy
MARK_MODEL_AS_NO_LONGER_NEEDED cellphone
CLEAR_ONSCREEN_COUNTER delivery_status
GET_GAME_TIMER timer_mobile_start
REMOVE_BLIP carlblip
MISSION_HAS_FINISHED
RETURN
}