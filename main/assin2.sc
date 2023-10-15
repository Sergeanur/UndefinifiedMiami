MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// ****************************	assin2 - Job 'Waste the Wife'  *****************************
// ***********Target will not leave car must kill her by ramming into car*******************
// ***********wanted bar will go up one for every five collision****************************
// ***************************************************************************************** 
// ***************************************************************************************** 
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
{
SCRIPT_NAME assin2

// Mission start stuff
GOSUB mission_start_assin2

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_assin2_failed
ENDIF

GOSUB mission_cleanup_assin2

MISSION_END
 
// Variables for mission
VAR_INT wife wifecar wifeblip wifecarhealth playerinarea
	
VAR_FLOAT wifecarstartx wifecarstarty wifecarstartz

VAR_FLOAT playertriggerx_a2 playertriggery_a2 playertriggerz_a2

VAR_INT player_has_not_reached_shop
VAR_INT wife_in_car triggerblip_a2 next_cam_view_a2
VAR_INT car_has_been_rammed_into in_area_on_fire_check
VAR_INT put_health_counter_onscreen_a2  
VAR_FLOAT wifecar_x wifecar_y wifecar_z

VAR_INT lastsample sampletoplay
VAR_INT playingaudio_a2 


		 



// **************************************** Mission Start **********************************

mission_start_assin2:				  

REGISTER_MISSION_GIVEN

flag_player_on_mission = 1

WAIT 0

LOAD_MISSION_TEXT ASSIN2 

//set any flags to zero
playerinarea = 0

//starting position of wifes car
wifecarstartx =	394.99157
wifecarstarty =	202.517593
wifecarstartz =	9.763453

//trigger point for player
playertriggerx_a2 = 403.978//406.01789
playertriggery_a2 = 222.629//210.283279
playertriggerz_a2 = 10.761//10.036718
  

//flags
player_has_not_reached_shop = 0
wife_in_car = 0
next_cam_view_a2 = 0
car_has_been_rammed_into = 0
in_area_on_fire_check = 0  
put_health_counter_onscreen_a2 = 0
playingaudio_a2 = 0
lastsample  = 99999
sampletoplay = 0
playerinarea = 0


//requesting/loading models
REQUEST_MODEL COMET
REQUEST_MODEL WFYRI
REQUEST_MODEL cellphone

WHILE NOT HAS_MODEL_LOADED COMET
	OR NOT HAS_MODEL_LOADED WFYRI
	OR NOT HAS_MODEL_LOADED cellphone
WAIT 0
ENDWHILE


///////////////////////////////////////////////////////////////////////////////////////cutscene
DO_FADE 1500 FADE_IN

SET_PED_DENSITY_MULTIPLIER 0.0
SET_CAR_DENSITY_MULTIPLIER 0.0

CLEAR_AREA 482.4669 244.3981 10.0611 1.0 FALSE
CLEAR_AREA_OF_CHARS 467.323 237.113 5.992 491.743 252.845 15.029

SWITCH_WIDESCREEN ON		  

SET_PLAYER_COORDINATES player1 482.462189 244.590836 10.101152  
SET_PLAYER_HEADING player1 359.023682

SET_FIXED_CAMERA_POSITION 482.462 242.743362 12.794998 0.0 0.0 0.0
CLEAR_AREA 482.462 242.743362 12.794998 1.0 FALSE
POINT_CAMERA_AT_PLAYER player1 FOLLOWPED JUMP_CUT
SET_CAMERA_BEHIND_PLAYER
SET_CHAR_ANSWERING_MOBILE scplayer TRUE

LOAD_MISSION_AUDIO 1 JOB2_1b
LOAD_MISSION_AUDIO 2 JOB1_1c


WHILE NOT HAS_MISSION_AUDIO_LOADED 1
   OR NOT HAS_MISSION_AUDIO_LOADED 2
	WAIT 0
ENDWHILE 

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

PRINT_NOW ( ASM2_A ) 10000 1 
PLAY_MISSION_AUDIO 1
WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
AND NOT IS_CHAR_DEAD scplayer
	WAIT 0
	IF IS_BUTTON_PRESSED PAD1 cross
		GOTO endasm2cs
	ENDIF
ENDWHILE
CLEAR_THIS_PRINT ASM2_A
CLEAR_MISSION_AUDIO 1


PRINT_NOW ( ASM1_C ) 10000 1 
PLAY_MISSION_AUDIO 2
WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
AND NOT IS_CHAR_DEAD scplayer
	WAIT 0
	IF IS_BUTTON_PRESSED PAD1 cross
		GOTO endasm2cs
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
		GOTO endasm2cs
	ENDIF
ENDWHILE
CLEAR_THIS_PRINT ASM1_B
CLEAR_MISSION_AUDIO 1


endasm2cs:

CLEAR_MISSION_AUDIO 1
CLEAR_MISSION_AUDIO 2
CLEAR_SMALL_PRINTS

WAIT 500

SET_CHAR_ANSWERING_MOBILE scplayer FALSE
MARK_MODEL_AS_NO_LONGER_NEEDED cellphone

DO_FADE 1500 FADE_OUT


SET_PED_DENSITY_MULTIPLIER 1.0
SET_CAR_DENSITY_MULTIPLIER 1.0



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

missionloopassin2:


WAIT 0



		////////////////////////////////////////////	GET TO LOCATION			///////////////////////////////////


//player must reach location
IF player_has_not_reached_shop = 0
//create wifes car
	
	PRINT_NOW ( ASM2_1 ) 10000 2 //Mrs Dawson will be leaving...
			
	ADD_BLIP_FOR_COORD playertriggerx_a2 playertriggery_a2 playertriggerz_a2 triggerblip_a2
	
	SWITCH_ROADS_OFF 397.0 220.0 -9.71 402.61 191.618 9.89 
	SWITCH_PED_ROADS_OFF 306.885 179.0982 -10.0907 413.129 203.139 10.89
	TIMERA = 0 

	player_has_not_reached_shop = 1

ENDIF


				////////////////////////////////////////////   CUTSCENE		///////////////////////////////////



//cutscene of wife getting in car
IF player_has_not_reached_shop = 1
	IF wife_in_car = 0
		IF LOCATE_STOPPED_PLAYER_ANY_MEANS_3D player1 playertriggerx_a2 playertriggery_a2 playertriggerz_a2 2.0 2.0 3.0 TRUE
			IF IS_PLAYER_SITTING_IN_ANY_CAR player1
				REMOVE_BLIP triggerblip_a2 
				SET_PLAYER_CONTROL player1 OFF
				SWITCH_WIDESCREEN ON
				CLEAR_AREA wifecarstartx wifecarstarty wifecarstartz 30.0 TRUE
				CREATE_CHAR PEDTYPE_CIVFEMALE WFYRI 379.342560 203.490821 11.392508 wife
				SHUT_CHAR_UP wife TRUE
				SET_CHAR_HEADING wife 268.973480
				SET_FIXED_CAMERA_POSITION 390.952 212.377 16.131 0.0 0.0 0.0
				POINT_CAMERA_AT_PLAYER player1 FIXED JUMP_CUT
				CLEAR_AREA wifecarstartx wifecarstarty wifecarstartz 15.0 TRUE
				CREATE_CAR COMET wifecarstartx wifecarstarty wifecarstartz wifecar
				CHANGE_CAR_COLOUR wifecar CARCOLOUR_TAXIYELLOW CARCOLOUR_TAXIYELLOW
				SET_CAR_HEADING wifecar 178.226822 
				SET_CAR_CRUISE_SPEED wifecar 0.0
				SET_CAR_DRIVING_STYLE wifecar 0
				SET_CAR_HEALTH wifecar 893 //899
				LOCK_CAR_DOORS wifecar CARLOCK_LOCKOUT_PLAYER_ONLY

				WHILE NOT next_cam_view_a2 = 5
						
				WAIT 0 
					
					IF NOT IS_CAR_DEAD wifecar
						IF NOT IS_CHAR_DEAD wife
							IF next_cam_view_a2 = 0
								SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER wife wifecar
								TIMERA = 0
								next_cam_view_a2 = 1
							ENDIF
						ENDIF
					ENDIF
					 
					IF NOT IS_CHAR_DEAD wife
						IF NOT IS_CAR_DEAD wifecar
							IF next_cam_view_a2 = 1
								IF TIMERA > 1000
									//LOAD_SCENE 378.606445 203.746796 11.028813 
									SET_FIXED_CAMERA_POSITION 378.606445 203.746796 11.028813 0.0 0.0 0.0//0.377258 -0.123169 0.172617
									POINT_CAMERA_AT_POINT 379.583679 203.623627 11.19348 JUMP_CUT
									PRINT_NOW ( ASM2_8 ) 6000 2//second brief hint...
									PRINT ( ASM2_10 ) 6000 2
									TIMERA = 0
		   							next_cam_view_a2 = 2
								ENDIF
							ENDIF
						ENDIF
					ENDIF 
						
					IF next_cam_view_a2 = 2
						IF NOT IS_CHAR_DEAD wife
							IF NOT IS_CAR_DEAD wifecar
								IF LOCATE_CHAR_ON_FOOT_3D wife 384.399414 203.401169 10.392508 1.5 1.5 1.5 FALSE
									CLEAR_AREA wifecarstartx wifecarstarty wifecarstartz 50.0 TRUE
									SET_FIXED_CAMERA_POSITION 390.022021 205.203796 10.932952 0.0 0.0 0.0
									SET_CHAR_COORDINATES wife 390.811462 202.591766 10.070621
								    SET_CHAR_HEADING wife 270.790283
									SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER wife wifecar
									POINT_CAMERA_AT_CAR wifecar FIXED JUMP_CUT
									next_cam_view_a2 = 3
								ELSE	//safety timer
									IF TIMERA > 14000	//safety timer
										SET_CHAR_COORDINATES wife 384.399414 203.401169 10.392508	//safety timer
										SET_CHAR_HEADING wife 270.0	//safety timer
										TIMERA = 0	//safety timer
									ENDIF	//safety timer
								ENDIF
							ENDIF
						ENDIF
					ENDIF

					
					IF next_cam_view_a2 = 3
						IF NOT IS_CHAR_DEAD wife
							IF NOT IS_CAR_DEAD wifecar
								IF IS_CHAR_SITTING_IN_CAR wife wifecar
									ADD_BLIP_FOR_CHAR wife wifeblip
									LOCK_CAR_DOORS wifecar CARLOCK_LOCKED
									SET_CAR_CRUISE_SPEED wifecar 15.0
									CAR_WANDER_RANDOMLY wifecar
									SET_CAR_DRIVING_STYLE wifecar DRIVINGMODE_SLOWDOWNFORCARS
									SET_CAR_ONLY_DAMAGED_BY_PLAYER wifecar TRUE
									// PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX 		   	
									// PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX 
									// PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX 
									SET_CHAR_CAN_BE_SHOT_IN_VEHICLE wife FALSE
									// PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX 		   	
									// PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX 
									// PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX 
									TIMERA = 0
									next_cam_view_a2 = 4
								ENDIF
							ENDIF
						ENDIF
					ENDIF

					IF next_cam_view_a2 = 4
						IF TIMERA > 4000
							RESTORE_CAMERA_JUMPCUT
							SET_CAMERA_BEHIND_PLAYER
							CLEAR_THIS_PRINT ( ASM2_10 )
							SWITCH_WIDESCREEN OFF
							SET_PLAYER_CONTROL player1 ON
							next_cam_view_a2 = 5
						ENDIF
					ENDIF
							

				ENDWHILE
	
				wife_in_car = 1
				player_has_not_reached_shop = 2
				ADD_STUCK_CAR_CHECK wifecar 0.5 1000
				ADD_UPSIDEDOWN_CAR_CHECK wifecar
				SHUT_PLAYER_UP player1 TRUE
				TIMERA = 0
				
			
			ELSE
			   
			   PRINT_NOW ( ASM2_9 ) 3000 2	 //get to location x...
			   //you need a car for this mission

			ENDIF
		ENDIF
	ENDIF
ENDIF 

		
		   ////////////////////////////////////////////////////////  CAR STUCK 	//////////////////////////////////////////////

	
IF wife_in_car = 1
	IF NOT IS_CAR_DEAD wifecar
		IF NOT IS_CAR_IN_WATER wifecar
			IF NOT IS_CAR_ON_FIRE wifecar
				IF IS_CAR_STUCK wifecar
				OR IS_CAR_STUCK_ON_ROOF wifecar
					IF NOT IS_CAR_ON_SCREEN wifecar
						GET_CAR_COORDINATES wifecar wifecar_x wifecar_y wifecar_z
						GET_CLOSEST_CAR_NODE wifecar_x wifecar_y wifecar_z wifecar_x wifecar_y wifecar_z
						IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY wifecar_x wifecar_y wifecar_z 4.0 4.0 3.0
							IF NOT IS_POINT_ON_SCREEN wifecar_x wifecar_y wifecar_z 3.0
								SET_CAR_CRUISE_SPEED wifecar 30.0
								SET_CAR_DRIVING_STYLE wifecar DRIVINGMODE_AVOIDCARS
								CAR_WANDER_RANDOMLY wifecar
				 			ENDIF
						ENDIF
			 		 ENDIF
			    ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF
			////////////////////////////////////////////////////////  UPDATE COUNTER ONSCREEN 	//////////////////////////////////////////////


//health counter onscreen
IF NOT IS_CAR_DEAD wifecar
	GET_CAR_HEALTH wifecar wifecarhealth
	wifecarhealth -= 243 //249
	wifecarhealth = wifecarhealth * 10
	wifecarhealth = wifecarhealth/65
	IF wifecarhealth <= 0
		CLEAR_ONSCREEN_COUNTER wifecarhealth 
	ENDIF
ELSE
	wifecarhealth = 0
ENDIF



IF player_has_not_reached_shop = 2
	IF put_health_counter_onscreen_a2 = 0
		DISPLAY_ONSCREEN_COUNTER_WITH_STRING wifecarhealth COUNTER_DISPLAY_BAR (ASM2_2)
		put_health_counter_onscreen_a2 = 1
	ENDIF
ENDIF


		
			////////////////////////////////////////////////////	WIFE IS IN CAR		//////////////////////////////////////////////////////
						
//wife is now in car
IF wife_in_car = 1
	IF player_has_not_reached_shop = 2
		IF NOT IS_CHAR_DEAD wife
			IF NOT IS_CAR_DEAD wifecar
				
				IF car_has_been_rammed_into = 0
					IF NOT IS_CAR_HEALTH_GREATER wifecar 892 //898
						SET_CAR_CRUISE_SPEED wifecar 29.0
						SET_CAR_DRIVING_STYLE wifecar DRIVINGMODE_AVOIDCARS
						car_has_been_rammed_into = 1
					ENDIF
				ENDIF
								 
			ENDIF
		ENDIF
	ENDIF
ENDIF
							////////////////////////////////////////	AUDIO	////////////////////////////////////					
			
///////////////////////////////////////wife1..oh my god...somebody help me

IF NOT IS_CHAR_DEAD wife
	
	IF playingaudio_a2 = 0
		IF NOT IS_CAR_DEAD wifecar
			IF IS_CAR_ON_FIRE wifecar
				IF lastsample > 1
					sampletoplay = 1
					playingaudio_a2 = 1
					LOAD_MISSION_AUDIO 1 JOB2_9///sample
				ENDIF
			ELSE
				IF wifecarhealth < 14//40
					IF lastsample > 2
						sampletoplay = 2
						playingaudio_a2 = 1
						LOAD_MISSION_AUDIO 1 JOB2_8///sample
					ENDIF
				ELSE
					IF wifecarhealth < 28//50
						IF lastsample > 3
							sampletoplay = 3
							playingaudio_a2 = 1
							LOAD_MISSION_AUDIO 1 JOB2_7///sombody help me
						ENDIF
					ELSE
						IF wifecarhealth < 45//60
							IF lastsample > 4
								sampletoplay = 4
								playingaudio_a2 = 1
								LOAD_MISSION_AUDIO 1 JOB2_6///sample
							ENDIF
						ELSE
							IF wifecarhealth < 59//70
								IF lastsample > 5
									sampletoplay = 5
									playingaudio_a2 = 1
									LOAD_MISSION_AUDIO 1 JOB2_5///sample
								ENDIF
							ELSE
								IF wifecarhealth < 72//80
									IF lastsample > 6
										sampletoplay = 6
										playingaudio_a2 = 1
										LOAD_MISSION_AUDIO 1 JOB2_4///help me				
									ENDIF
								ELSE
									IF wifecarhealth < 88//90
										IF lastsample > 7
											sampletoplay = 7
											playingaudio_a2 = 1
											LOAD_MISSION_AUDIO 1 JOB2_3///sample
										ENDIF				
									ENDIF
								ENDIF
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
		
	ELSE
		IF playingaudio_a2 = 1
			IF HAS_MISSION_AUDIO_LOADED 1
				PLAY_MISSION_AUDIO 1
				
					IF sampletoplay = 2
					OR sampletoplay = 4
					OR sampletoplay = 5
					OR sampletoplay = 7
						PRINT_NOW ( ASM2_13 ) 3000 1  //Oh my God!
					ENDIF
				
					IF sampletoplay = 3
						PRINT_NOW ( ASM2_12 ) 3000 1  //Somebody help me!	 
					ENDIF

					IF sampletoplay = 6
						PRINT_NOW ( ASM2_11 ) 3000 1 //Help me!	 
					ENDIF
				 
				playingaudio_a2 = 2
			ENDIF
		ELSE
			IF playingaudio_a2 = 2
		 		IF HAS_MISSION_AUDIO_FINISHED 1
				   	playingaudio_a2 = 0
					CLEAR_MISSION_AUDIO 1
										
					IF sampletoplay = 2
					OR sampletoplay = 4
					OR sampletoplay = 5
					OR sampletoplay = 7
						CLEAR_THIS_PRINT ( ASM2_13 ) //Oh my God!
					ENDIF
				
					IF sampletoplay = 3
						CLEAR_THIS_PRINT ( ASM2_12 ) //Somebody help me!	 
					ENDIF

					IF sampletoplay = 6
						CLEAR_THIS_PRINT ( ASM2_11 ) //Help me!	 
					ENDIF
					
				    lastsample = sampletoplay
				ENDIF
			ENDIF
		ENDIF
	ENDIF

ELSE		
	playingaudio_a2 = 0
	CLEAR_MISSION_AUDIO 1
ENDIF	
	

				
		   //////////////////////////////////////////////	CAR ON FIRE CHECK	///////////////////////////////////////////////			   

	   
// If the car is on fire do the check as to whether the player is out of the area
IF NOT IS_CAR_DEAD wifecar
	IF NOT IS_CHAR_DEAD wife
		IF IS_CAR_ON_FIRE wifecar
			IF LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 wifecar 20.0 20.0 FALSE
				playerinarea = 1
					IF in_area_on_fire_check = 0
						PRINT_NOW ( ASM2_3 ) 3000 2 //Her cars gonna blow! get out of there...
						in_area_on_fire_check = 1
					ENDIF
			ELSE
			
				playerinarea = 0
					IF in_area_on_fire_check = 0
						PRINT_NOW ( ASM2_3 ) 3000 2 //Her cars gonna blow! get out of there...
						in_area_on_fire_check = 1
					ENDIF
			ENDIF 
		ENDIF
	ENDIF
ENDIF 



		//////////////////////////////////////////////		MISSION PASS		///////////////////////////////////////////////		


//mission passes if she is dead and has not been killed by using any weapons
IF wife_in_car > 0
	IF IS_CAR_DEAD wifecar
	AND IS_CHAR_DEAD wife
		IF NOT HAS_CAR_BEEN_DAMAGED_BY_WEAPON wifecar WEAPONTYPE_ANYWEAPON
			IF NOT HAS_CHAR_BEEN_DAMAGED_BY_WEAPON wife WEAPONTYPE_ANYWEAPON	
			AND playerinarea = 0
			 	GOTO mission_assin2_passed
		   	ELSE
				PRINT_NOW ( ASM2_6 ) 5000 1 //You were too near the accident scene!
				GOTO mission_assin2_failed
			ENDIF
		ENDIF
	ENDIF
ENDIF


		//////////////////////////////////////////////		MISSION FAIL - out of range	///////////////////////////////////////////////	

//out of range
IF wife_in_car > 0
	IF NOT IS_CAR_DEAD wifecar
		IF NOT IS_CHAR_DEAD wife
			IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 wife 250.0 250.0 FALSE
				IF NOT IS_CHAR_ON_SCREEN wife
					PRINT_NOW ( ASM2_5 ) 5000 1
					GOTO mission_assin2_failed
				ENDIF
			ENDIF
		ENDIF
	ENDIF 
ENDIF

  			
			////////////////////////////////////////////	IF PLAYER HAS DAMAGED CAR WHILE WIFE IN		///////////////////////////////////

//Checking whether car has been hit by any weapon WHILE WIFE NOT IN
IF wife_in_car > 0
	IF NOT IS_CAR_DEAD wifecar
		IF NOT IS_CHAR_DEAD wife
			IF IS_CHAR_IN_CAR wife wifecar 
				IF HAS_CAR_BEEN_DAMAGED_BY_WEAPON wifecar WEAPONTYPE_ANYWEAPON
				   PRINT_NOW ( ASM2_7 ) 5000 1 //It's got to look like an accident dont use weapons!
				   GOTO mission_assin2_failed
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF
 
	

GOTO missionloopassin2





 // **************************************** Mission haitian3 failed ************************

mission_assin2_failed:
PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed"
RETURN

   

// **************************************** mission haitian3 passed ************************

mission_assin2_passed:

flag_assin_mission2_passed = 1
REGISTER_MISSION_PASSED ( JOB_2 )
PRINT_WITH_NUMBER_BIG ( M_PASS ) 2000 5000 1 //"Mission Passed!"
PLAY_MISSION_PASSED_TUNE 1
PLAYER_MADE_PROGRESS 1
ADD_NUMBER_OF_ASSASSINATIONS 1
CLEAR_WANTED_LEVEL player1
ADD_SCORE player1 2000
REMOVE_BLIP assasin_contact_blip
RETURN
		


// ********************************** mission cleanup **************************************

mission_cleanup_assin2:

flag_player_on_mission = 0
SHUT_PLAYER_UP player1 FALSE
SWITCH_ROADS_ON 397.0 220.0 -9.71 402.61 191.618 9.89 
SWITCH_PED_ROADS_ON 306.885 179.0982 -10.0907 413.129 203.139 10.89
MARK_MODEL_AS_NO_LONGER_NEEDED WFYRI
MARK_MODEL_AS_NO_LONGER_NEEDED COMET
MARK_MODEL_AS_NO_LONGER_NEEDED cellphone
REMOVE_BLIP wifeblip
REMOVE_BLIP	triggerblip_a2
CLEAR_ONSCREEN_COUNTER wifecarhealth
GET_GAME_TIMER timer_mobile_start
MISSION_HAS_FINISHED
RETURN
}


