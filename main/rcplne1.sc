MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// ****************************** RCPLNE1 - RC Plane Checkpoint Race ***********************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
{
SCRIPT_NAME RCPLNE1

// Mission start stuff
GOSUB mission_start_rcplane

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_rcplane_failed
ENDIF

GOSUB mission_cleanup_rcplane

MISSION_END

 
// ******************************** Variables for mission **********************************

VAR_FLOAT rcp_plane_x rcp_plane_y rcp_plane_z rcp_plane_headings
VAR_FLOAT rcp_difference_x_float_d rcp_difference_y_float_d  rcp_sum_difference_d_xy	
VAR_FLOAT rcp_plane1_locate_size rcp_plane2_locate_size rcp_plane3_locate_size
VAR_FLOAT rcp_plane_distance_from_cp rcp_player1_distance_from_cp
VAR_FLOAT rcp_road1_x rcp_road1_y rcp_road1_z rcp_road2_x rcp_road2_y rcp_road2_z

VAR_FLOAT rcp_plane1_stuck_x rcp_plane1_stuck_y rcp_plane1_stuck_z
VAR_FLOAT rcp_plane2_stuck_x rcp_plane2_stuck_y rcp_plane2_stuck_z
VAR_FLOAT rcp_plane3_stuck_x rcp_plane3_stuck_y rcp_plane3_stuck_z
VAR_FLOAT rcp_plane_stuck_x rcp_plane_stuck_y rcp_plane_stuck_z

VAR_FLOAT rcp_player1_cp_x rcp_player1_cp_y rcp_player1_cp_z
VAR_FLOAT rcp_blip_2nd_x rcp_blip_2nd_y rcp_blip_2nd_z
VAR_FLOAT rcp_plane1_cp_x rcp_plane1_cp_y rcp_plane1_cp_z
VAR_FLOAT rcp_plane2_cp_x rcp_plane2_cp_y rcp_plane2_cp_z
VAR_FLOAT rcp_plane3_cp_x rcp_plane3_cp_y rcp_plane3_cp_z

VAR_FLOAT rcp_gosub_cp_x rcp_gosub_cp_y rcp_gosub_cp_z rcp_gosub_cp_2nd_x rcp_gosub_cp_2nd_y rcp_gosub_cp_2nd_z	rcp_plane_speed

VAR_INT rcp_blip_chase rcp_second_blip rcp_blip_plane1 rcp_blip_plane2 rcp_blip_plane3 vanfor_rcplane_race
VAR_INT rcp_race_plane1 rcp_race_plane2 rcp_race_plane3 rcp_plane_health rcp_gosub_race_plane	rcp_playerplane
VAR_INT rcp_driver_plane1 rcp_driver_plane2 rcp_driver_plane3
VAR_INT rcp_player_cpcounter rcp_plane1_cpcounter rcp_plane2_cpcounter rcp_plane3_cpcounter rcp_gosub_cpcounter
VAR_INT rcp_position rcp_race_timer rcp_plane1_stuck_timer rcp_plane2_stuck_timer rcp_plane3_stuck_timer
VAR_INT rcp_race_timer_start rcp_timer_started rcp_stuck_timer
VAR_INT rcp_total_checkpoints rcp_total_checkpoints_minus1
VAR_INT rcp_game_time
VAR_INT rcp_timer_reset_flag playerpassedrcplane1

VAR_FLOAT rcp_cp0_x rcp_cp0_y rcp_cp0_z rcp_cp1_x rcp_cp1_y rcp_cp1_z rcp_cp2_x rcp_cp2_y rcp_cp2_z rcp_cp3_x rcp_cp3_y rcp_cp3_z rcp_cp4_x rcp_cp4_y rcp_cp4_z 
VAR_FLOAT rcp_cp5_x rcp_cp5_y rcp_cp5_z rcp_cp6_x rcp_cp6_y rcp_cp6_z rcp_cp7_x rcp_cp7_y rcp_cp7_z rcp_cp8_x rcp_cp8_y rcp_cp8_z rcp_cp9_x rcp_cp9_y rcp_cp9_z 
VAR_FLOAT rcp_cp10_x rcp_cp10_y rcp_cp10_z rcp_cp11_x rcp_cp11_y rcp_cp11_z rcp_cp12_x rcp_cp12_y rcp_cp12_z rcp_cp13_x rcp_cp13_y rcp_cp13_z 
VAR_FLOAT rcp_cp14_x rcp_cp14_y rcp_cp14_z rcp_cp15_x rcp_cp15_y rcp_cp15_z rcp_cp16_x rcp_cp16_y rcp_cp16_z rcp_cp17_x rcp_cp17_y rcp_cp17_z 
VAR_FLOAT rcp_cp18_x rcp_cp18_y rcp_cp18_z rcp_cp19_x rcp_cp19_y rcp_cp19_z rcp_cp20_x rcp_cp20_y rcp_cp20_z rcp_cp21_x rcp_cp21_y rcp_cp21_z 
VAR_FLOAT rcp_cp22_x rcp_cp22_y rcp_cp22_z rcp_cp23_x rcp_cp23_y rcp_cp23_z rcp_cp24_x rcp_cp24_y rcp_cp24_z rcp_cp25_x rcp_cp25_y rcp_cp25_z
VAR_FLOAT rcp_cp26_x rcp_cp26_y rcp_cp26_z rcp_cp27_x rcp_cp27_y rcp_cp27_z rcp_cp28_x rcp_cp28_y rcp_cp28_z rcp_cp29_x rcp_cp29_y rcp_cp29_z 



VAR_INT rcplane_wanted_level 

VAR_INT race_timer_seconds_plane1
VAR_INT race_timer_seconds2_plane1 
VAR_INT race_timer_mins_plane1


// ************************************ Mission Start **************************************

mission_start_rcplane:

flag_player_on_mission = 1
flag_player_on_rc_mission = 1 //PC FIX PC FIX PC FIX PC FIX PC FIX PC FIX PC FIX


IF playerpassedrcplane1 = 0
	REGISTER_MISSION_GIVEN
ENDIF

WAIT 0

LOAD_MISSION_TEXT RCPLNE1
 

REQUEST_MODEL rcbaron
WHILE NOT HAS_MODEL_LOADED rcbaron
WAIT 0
ENDWHILE


rcp_total_checkpoints = 28 

rcp_cp0_x =	313.0     //start for player
rcp_cp0_y = 1238.332
rcp_cp0_z =	27.546

rcp_cp1_x = 317.926
rcp_cp1_y = 1219.877
rcp_cp1_z = 26.554
 
rcp_cp2_x = 321.350
rcp_cp2_y = 1102.111
rcp_cp2_z = 31.448

rcp_cp3_x =	317.778
rcp_cp3_y = 949.340
rcp_cp3_z =	29.25

rcp_cp4_x =	289.354
rcp_cp4_y = 789.471
rcp_cp4_z =	27.426

rcp_cp5_x = 201.599
rcp_cp5_y =	689.725
rcp_cp5_z = 27.896

rcp_cp6_x =	378.602//381.18
rcp_cp6_y = 564.227//560.238
rcp_cp6_z = 20.846	 //
	
rcp_cp7_x =	346.553
rcp_cp7_y = 445.865
rcp_cp7_z = 19.168	//

rcp_cp8_x =	331.891
rcp_cp8_y =	344.459
rcp_cp8_z = 18.385	 //very low

rcp_cp9_x =	337.064
rcp_cp9_y =	243.410
rcp_cp9_z = 24.428

rcp_cp10_x = 407.542
rcp_cp10_y = 102.447
rcp_cp10_z = 24.134

rcp_cp11_x = 332.597
rcp_cp11_y = -12.219
rcp_cp11_z = 25.134
 
rcp_cp12_x = 284.866
rcp_cp12_y = -144.529
rcp_cp12_z = 22.046
 
rcp_cp13_x = 225.013
rcp_cp13_y = -271.518
rcp_cp13_z = 19.929

rcp_cp14_x = 194.309
rcp_cp14_y = -365.009
rcp_cp14_z = 19.146  
				   /////////////////////////
rcp_cp15_x = 179.89
rcp_cp15_y = -500.032
rcp_cp15_z = 17.304	 //

rcp_cp16_x = 171.669
rcp_cp16_y = -638.857
rcp_cp16_z = 17.328	 //

rcp_cp17_x = 149.798
rcp_cp17_y = -738.283
rcp_cp17_z = 16.001	 //	last

rcp_cp18_x = 95.276
rcp_cp18_y = -838.345
rcp_cp18_z = 15.527 //last

rcp_cp19_x = -22.699
rcp_cp19_y = -869.548
rcp_cp19_z = 16.142	  

rcp_cp20_x = -107.153
rcp_cp20_y = -895.34
rcp_cp20_z = 18.43	 

rcp_cp21_x = -190.477
rcp_cp21_y = -944.935
rcp_cp21_z = 20.094	 

rcp_cp22_x = -186.305 //181
rcp_cp22_y = -1075.039
rcp_cp22_z = 32.099	 

rcp_cp23_x = -193.016 ///change +2
rcp_cp23_y = -1232.925
rcp_cp23_z = 16.655	  //

rcp_cp24_x = -164.456 //change +2
rcp_cp24_y = -1402.917
rcp_cp24_z = 16.294	//

rcp_cp25_x = -115.326//change +2
rcp_cp25_y = -1512.663
rcp_cp25_z = 15.455	 //

rcp_cp26_x = -11.818
rcp_cp26_y = -1576.647
rcp_cp26_z = 15.960//

rcp_cp27_x = 110.560
rcp_cp27_y = -1588.121//-1473.435
rcp_cp27_z = 16.516//

rcp_cp28_x = 174.464//52.914
rcp_cp28_y = -1527.732//-1248.344
rcp_cp28_z = 20.699//34.36

rcp_cp29_x = 259.539//41.814
rcp_cp29_y = -1234.819//-1105.628
rcp_cp29_z = 32.351//30.164




rcp_plane1_stuck_x = 316.0  	   //plane 1 start
rcp_plane1_stuck_y = 1238.332 
rcp_plane1_stuck_z = 26.554

rcp_plane2_stuck_x = 319.0	   //plane 2 start
rcp_plane2_stuck_y = 1238.332 
rcp_plane2_stuck_z = 26.554

rcp_plane3_stuck_x = 322.0 	   //plane 3 start
rcp_plane3_stuck_y = 1238.332
rcp_plane3_stuck_z = 26.554

rcp_plane_headings = 182.290


rcp_gosub_cpcounter    = 0
rcp_player_cpcounter   = 0
rcp_plane1_cpcounter   = 0
rcp_plane2_cpcounter   = 0
rcp_plane3_cpcounter   = 0
rcp_plane1_locate_size  = 4.0
rcp_plane2_locate_size  = 4.0
rcp_plane3_locate_size  = 4.0



	
	//initial cutscene
	SET_POLICE_IGNORE_PLAYER player1 ON
	
	STORE_CAR_PLAYER_IS_IN player1 vanfor_rcplane_race
	
	IF NOT IS_CAR_DEAD vanfor_rcplane_race
		LOCK_CAR_DOORS vanfor_rcplane_race CARLOCK_LOCKED
	ENDIF
	
	STORE_WANTED_LEVEL player1 rcplane_wanted_level
	CLEAR_WANTED_LEVEL player1
	
	CLEAR_AREA rcp_cp0_x rcp_cp0_y rcp_cp0_z 80.0 TRUE
	
	SWITCH_WIDESCREEN ON

	//create opponents
	CREATE_CAR rcbaron rcp_plane1_stuck_x rcp_plane1_stuck_y rcp_plane1_stuck_z rcp_race_plane1
	SET_CAR_STRONG rcp_race_plane1 TRUE
	SET_UPSIDEDOWN_CAR_NOT_DAMAGED rcp_race_plane1 TRUE
	SET_CAR_HEADING rcp_race_plane1 rcp_plane_headings
	SET_CAR_ONLY_DAMAGED_BY_PLAYER rcp_race_plane1 TRUE
	
	CREATE_CAR rcbaron rcp_plane2_stuck_x rcp_plane2_stuck_y rcp_plane2_stuck_z rcp_race_plane2
	SET_CAR_STRONG rcp_race_plane2 TRUE
	SET_UPSIDEDOWN_CAR_NOT_DAMAGED rcp_race_plane2 TRUE
	SET_CAR_HEADING rcp_race_plane2 rcp_plane_headings
	SET_CAR_ONLY_DAMAGED_BY_PLAYER rcp_race_plane2 TRUE
	
	CREATE_CAR rcbaron rcp_plane3_stuck_x rcp_plane3_stuck_y rcp_plane3_stuck_z rcp_race_plane3
	SET_CAR_STRONG rcp_race_plane3 TRUE
	SET_UPSIDEDOWN_CAR_NOT_DAMAGED rcp_race_plane3 TRUE
	SET_CAR_HEADING rcp_race_plane3 rcp_plane_headings
	SET_CAR_ONLY_DAMAGED_BY_PLAYER rcp_race_plane3 TRUE
			
	GIVE_REMOTE_CONTROLLED_MODEL_TO_PLAYER player1 rcp_cp0_x rcp_cp0_y rcp_cp0_z 182.290 rcbaron
	GET_REMOTE_CONTROLLED_CAR player1 rcp_playerplane
	SET_ENABLE_RC_DETONATE_ON_CONTACT FALSE 

		
	SET_FIXED_CAMERA_POSITION 323.617279 1239.220337 26.800529 0.0 0.0 0.0
	POINT_CAMERA_AT_POINT 322.70871 1238.806763 26.85948 JUMP_CUT
	
		
	DO_FADE 3000 FADE_IN

	WHILE GET_FADING_STATUS
	 	WAIT 0
	ENDWHILE


		 TIMERA = 0

		 WHILE TIMERA < 5000
		   			   
		 WAIT 0
		 
		 PRINT_NOW ( RCPL1_4 ) 5000 2 //compete in race
		 		 					
			 IF IS_BUTTON_PRESSED PAD1 cross
			 	GOTO endrcplanelable
			 ENDIF

		 ENDWHILE
		

		 TIMERA = 0

		 LOAD_SCENE 289.354 789.471 27.426
	     SET_FIXED_CAMERA_POSITION 307.078 842.687 33.651 0.0 0.0 0.0
		 POINT_CAMERA_AT_POINT 289.354 789.471 27.426 JUMP_CUT
		 
		 WHILE TIMERA < 5000
		   			   
		 WAIT 0

		 PRINT_NOW ( RCPL1_5 ) 5000 2 //go through the centre checkpoint
		 DRAW_WEAPONSHOP_CORONA 289.354 789.471 27.426 7.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
		 		 		 		 					
			 IF IS_BUTTON_PRESSED PAD1 cross
			 	GOTO endrcplanelable
			 ENDIF

		 ENDWHILE


		 TIMERA = 0

		 WHILE TIMERA < 5000
		   			   
		 WAIT 0

		 SET_FIXED_CAMERA_POSITION 311.378937 1236.671997 26.99365 0.0 0.0 0.0
		 POINT_CAMERA_AT_POINT 312.231079 1237.192505 26.939667 JUMP_CUT
	     
    	 PRINT_NOW ( RCPL1_6 ) 5000 2 // ~g~If you wish to quit this mission press the ~o~| ~g~button to detonate your RC Plane.
		 		 		 		 		 					
			 IF IS_BUTTON_PRESSED PAD1 cross
			 	GOTO endrcplanelable
			 ENDIF

		 ENDWHILE

 		
  endrcplanelable:
	
		IF NOT IS_CAR_DEAD rcp_playerplane
			CLEAR_SMALL_PRINTS
			POINT_CAMERA_AT_CAR rcp_playerplane CAM_ON_A_STRING JUMP_CUT
			WAIT 0
			SET_CAMERA_ZOOM 0
			WAIT 300
			SWITCH_WIDESCREEN OFF
		ENDIF
		
 		

rcp_race_start:

rcp_total_checkpoints_minus1 = rcp_total_checkpoints - 1

	SET_PLAYER_CONTROL player1 OFF
	SET_EVERYONE_IGNORE_PLAYER player1 TRUE
	SET_ALL_CARS_CAN_BE_DAMAGED FALSE
   	PRINT_BIG ( RACE2 ) 1100 4
	ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_RACE_START_3
	WAIT 1000
	PRINT_BIG ( RACE3 ) 1100 4
	ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_RACE_START_2
	WAIT 1000
	PRINT_BIG  ( RACE4 ) 1100 4
	ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_RACE_START_1
	WAIT 1000
	PRINT_BIG ( RACE5 ) 800 4  //"GO!"
	ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_RACE_START_GO
   	SET_PLAYER_CONTROL player1 ON
	SET_EVERYONE_IGNORE_PLAYER player1 FALSE
	SET_ALL_CARS_CAN_BE_DAMAGED TRUE

GET_CONTROLLER_MODE controlmode
IF controlmode = 3
	PRINT_HELP ( PLANE_4 )
ELSE
	PRINT_HELP ( PLANE_H )
ENDIF

IF IS_CAR_DEAD rcp_race_plane1
	GOTO mission_rcplane_failed
ENDIF

IF IS_CAR_DEAD rcp_race_plane2
	GOTO mission_rcplane_failed
ENDIF

IF IS_CAR_DEAD rcp_race_plane3
	GOTO mission_rcplane_failed
ENDIF

IF NOT IS_CAR_DEAD rcp_race_plane1
	ADD_BLIP_FOR_CAR_OLD rcp_race_plane1 RED MARKER_ONLY rcp_blip_plane1
ENDIF		

IF NOT IS_CAR_DEAD rcp_race_plane2
	ADD_BLIP_FOR_CAR_OLD rcp_race_plane2 RED MARKER_ONLY rcp_blip_plane2
ENDIF			

IF NOT IS_CAR_DEAD rcp_race_plane3
	ADD_BLIP_FOR_CAR_OLD rcp_race_plane3 RED MARKER_ONLY rcp_blip_plane3
ENDIF

GOSUB rcp_get_next_checkpoint
rcp_player1_cp_x = rcp_gosub_cp_x
rcp_player1_cp_y = rcp_gosub_cp_y
rcp_player1_cp_z = rcp_gosub_cp_z
rcp_blip_2nd_x = rcp_gosub_cp_2nd_x
rcp_blip_2nd_y = rcp_gosub_cp_2nd_y
rcp_blip_2nd_z = rcp_gosub_cp_2nd_z

rcp_plane1_cp_x = rcp_gosub_cp_x
rcp_plane1_cp_y = rcp_gosub_cp_y
rcp_plane1_cp_z = rcp_gosub_cp_z

rcp_plane2_cp_x = rcp_gosub_cp_x
rcp_plane2_cp_y = rcp_gosub_cp_y
rcp_plane2_cp_z = rcp_gosub_cp_z

rcp_plane3_cp_x = rcp_gosub_cp_x
rcp_plane3_cp_y = rcp_gosub_cp_y
rcp_plane3_cp_z = rcp_gosub_cp_z

ADD_BLIP_FOR_COORD rcp_player1_cp_x rcp_player1_cp_y rcp_player1_cp_z rcp_blip_chase
ADD_BLIP_FOR_COORD_OLD rcp_blip_2nd_x rcp_blip_2nd_y rcp_blip_2nd_z PURPLE BLIP_ONLY rcp_second_blip
CHANGE_BLIP_SCALE rcp_second_blip 2
DIM_BLIP rcp_second_blip TRUE
 

PLANE_GOTO_COORDS rcp_race_plane1 rcp_plane1_cp_x rcp_plane1_cp_y rcp_plane1_cp_z 30

PLANE_GOTO_COORDS rcp_race_plane2 rcp_plane2_cp_x rcp_plane2_cp_y rcp_plane2_cp_z 25

PLANE_GOTO_COORDS rcp_race_plane3 rcp_plane3_cp_x rcp_plane3_cp_y rcp_plane3_cp_z 35


//GET_GAME_TIMER rcp_race_timer_start
rcp_race_timer = 0
DISPLAY_ONSCREEN_TIMER_WITH_STRING rcp_race_timer TIMER_UP ( RCH1_5 )

IF IS_CAR_DEAD rcp_playerplane
	GOTO mission_rcplane_failed
ENDIF


WHILE rcp_player_cpcounter < rcp_total_checkpoints

	WAIT 0

	CLEAR_AREA -447.80 1442.95 10.0 120.0 FALSE

//	GET_GAME_TIMER rcp_game_time
//	rcp_race_timer = rcp_game_time - rcp_race_timer_start
//	rcp_race_timer = rcp_race_timer / 1000
	 	
	rcp_position = 0

   
	IF NOT IS_CAR_DEAD rcp_playerplane
		IF LOCATE_CAR_3D rcp_playerplane rcp_player1_cp_x rcp_player1_cp_y rcp_player1_cp_z 7.5 7.5 7.5 0
			
			++ rcp_player_cpcounter
					   
			REMOVE_BLIP rcp_blip_chase

			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE

			REMOVE_BLIP rcp_second_blip
			
			rcp_gosub_cpcounter = rcp_player_cpcounter
			GOSUB rcp_get_next_checkpoint
			rcp_player1_cp_x = rcp_gosub_cp_x
			rcp_player1_cp_y = rcp_gosub_cp_y
			rcp_player1_cp_z = rcp_gosub_cp_z
			rcp_blip_2nd_x = rcp_gosub_cp_2nd_x
			rcp_blip_2nd_y = rcp_gosub_cp_2nd_y
			rcp_blip_2nd_z = rcp_gosub_cp_2nd_z
			
			IF rcp_player_cpcounter = rcp_total_checkpoints
				GOTO mission_rcplane_passed		
			ENDIF

			ADD_BLIP_FOR_COORD rcp_player1_cp_x rcp_player1_cp_y rcp_player1_cp_z rcp_blip_chase

			IF NOT rcp_player_cpcounter = rcp_total_checkpoints_minus1
				ADD_BLIP_FOR_COORD_OLD rcp_blip_2nd_x rcp_blip_2nd_y rcp_blip_2nd_z PURPLE BLIP_ONLY rcp_second_blip
				DIM_BLIP rcp_second_blip ON
				CHANGE_BLIP_SCALE rcp_second_blip 2
			ENDIF
		ENDIF
	ENDIF
			
	IF NOT IS_CAR_DEAD rcp_race_plane1
		
		rcp_gosub_race_plane = rcp_race_plane1
		rcp_gosub_cpcounter = rcp_plane1_cpcounter
		rcp_plane_stuck_x = rcp_plane1_stuck_x
		rcp_plane_stuck_y = rcp_plane1_stuck_y
		rcp_plane_stuck_z = rcp_plane1_stuck_z
		rcp_timer_started = rcp_plane1_stuck_timer
		GOSUB rcp_race_plane_stuck_checks
		rcp_plane1_stuck_x = rcp_plane_stuck_x
		rcp_plane1_stuck_y = rcp_plane_stuck_y
		rcp_plane1_stuck_z = rcp_plane_stuck_z
		rcp_plane1_stuck_timer = rcp_timer_started
		
		IF NOT IS_CAR_DEAD rcp_race_plane1
			IF LOCATE_CAR_3D rcp_race_plane1 rcp_plane1_cp_x rcp_plane1_cp_y rcp_plane1_cp_z rcp_plane1_locate_size rcp_plane1_locate_size rcp_plane1_locate_size 0
										
				++ rcp_plane1_cpcounter
				rcp_gosub_cpcounter = rcp_plane1_cpcounter
				GOSUB rcp_get_next_checkpoint
				rcp_plane1_cp_x = rcp_gosub_cp_x
				rcp_plane1_cp_y = rcp_gosub_cp_y
				rcp_plane1_cp_z = rcp_gosub_cp_z
				
//				IF rcp_plane1_cpcounter = 17
//					rcp_plane1_locate_size = 6.0
//				ENDIF

				IF rcp_plane1_cpcounter = rcp_total_checkpoints
					PRINT_NOW ( RACEFA ) 5000 1 //"~r~You failed to win the race!"
					GOTO mission_rcplane_failed		
				ENDIF
				
				PLANE_GOTO_COORDS rcp_race_plane1 rcp_plane1_cp_x rcp_plane1_cp_y rcp_plane1_cp_z 36

			ENDIF
		ENDIF
	ENDIF


	IF NOT IS_CAR_DEAD rcp_race_plane2

		rcp_gosub_race_plane = rcp_race_plane2
		rcp_gosub_cpcounter = rcp_plane2_cpcounter
		rcp_plane_stuck_x = rcp_plane2_stuck_x
		rcp_plane_stuck_y = rcp_plane2_stuck_y
		rcp_plane_stuck_z = rcp_plane2_stuck_z
		rcp_timer_started = rcp_plane2_stuck_timer
		GOSUB rcp_race_plane_stuck_checks
		rcp_plane2_stuck_x = rcp_plane_stuck_x
		rcp_plane2_stuck_y = rcp_plane_stuck_y
		rcp_plane2_stuck_z = rcp_plane_stuck_z
		rcp_plane2_stuck_timer = rcp_timer_started

		IF NOT IS_CAR_DEAD rcp_race_plane2
			IF LOCATE_CAR_3D rcp_race_plane2 rcp_plane2_cp_x rcp_plane2_cp_y rcp_plane2_cp_z rcp_plane2_locate_size rcp_plane2_locate_size rcp_plane2_locate_size 0
		   
				++ rcp_plane2_cpcounter
				rcp_gosub_cpcounter = rcp_plane2_cpcounter
				GOSUB rcp_get_next_checkpoint
				rcp_plane2_cp_x = rcp_gosub_cp_x
				rcp_plane2_cp_y = rcp_gosub_cp_y
				rcp_plane2_cp_z = rcp_gosub_cp_z

//				IF rcp_plane2_cpcounter = 17
//					rcp_plane2_locate_size = 6.0
//				ENDIF

				IF rcp_plane2_cpcounter = rcp_total_checkpoints
					PRINT_NOW ( RACEFA ) 5000 1 //"~r~You failed to win the race!"
					GOTO mission_rcplane_failed		
				ENDIF
				
				PLANE_GOTO_COORDS rcp_race_plane2 rcp_plane2_cp_x rcp_plane2_cp_y rcp_plane2_cp_z 27

			ENDIF
		ENDIF
	ENDIF


	IF NOT IS_CAR_DEAD rcp_race_plane3
		
		rcp_gosub_race_plane = rcp_race_plane3
		rcp_gosub_cpcounter = rcp_plane3_cpcounter
		rcp_plane_stuck_x = rcp_plane3_stuck_x
		rcp_plane_stuck_y = rcp_plane3_stuck_y
		rcp_plane_stuck_z = rcp_plane3_stuck_z
		rcp_timer_started = rcp_plane3_stuck_timer
		GOSUB rcp_race_plane_stuck_checks
		rcp_plane3_stuck_x = rcp_plane_stuck_x
		rcp_plane3_stuck_y = rcp_plane_stuck_y
		rcp_plane3_stuck_z = rcp_plane_stuck_z
		rcp_plane3_stuck_timer = rcp_timer_started

		IF NOT IS_CAR_DEAD rcp_race_plane3
			IF LOCATE_CAR_3D rcp_race_plane3 rcp_plane3_cp_x rcp_plane3_cp_y rcp_plane3_cp_z rcp_plane3_locate_size rcp_plane3_locate_size rcp_plane3_locate_size 0
		

				++ rcp_plane3_cpcounter
				rcp_gosub_cpcounter = rcp_plane3_cpcounter
				GOSUB rcp_get_next_checkpoint
				rcp_plane3_cp_x = rcp_gosub_cp_x
				rcp_plane3_cp_y = rcp_gosub_cp_y
				rcp_plane3_cp_z = rcp_gosub_cp_z
				
//				IF rcp_plane3_cpcounter = 17
//					rcp_plane3_locate_size = 6.0
//				ENDIF
				
				IF rcp_plane3_cpcounter = rcp_total_checkpoints
					PRINT_NOW ( RACEFA ) 5000 1 //"~r~You failed to win the race!"
					GOTO mission_rcplane_failed		
				ENDIF

				PLANE_GOTO_COORDS rcp_race_plane3 rcp_plane3_cp_x rcp_plane3_cp_y rcp_plane3_cp_z 42
			
			ENDIF
		ENDIF
	ENDIF

	IF rcp_position = 0
		PRINT_NOW FIRST 100 1 //"1st"
	ENDIF

	IF rcp_position = 1
		PRINT_NOW SECOND 100 1 //"2nd"
	ENDIF

	IF rcp_position = 2
		PRINT_NOW THIRD 100 1 //"3rd"
	ENDIF

	IF rcp_position = 3
		PRINT_NOW FOURTH 100 1 //"4th"
	ENDIF

	IF rcp_player_cpcounter = rcp_total_checkpoints_minus1
		DRAW_WEAPONSHOP_CORONA rcp_player1_cp_x rcp_player1_cp_y rcp_player1_cp_z 7.0 CORONATYPE_CIRCLE FLARETYPE_NONE 100 0 100
	ELSE
		DRAW_WEAPONSHOP_CORONA rcp_player1_cp_x rcp_player1_cp_y rcp_player1_cp_z 7.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205   //0 0 100
	ENDIF

	IF IS_CAR_DEAD rcp_playerplane
		GOTO mission_rcplane_failed
	ENDIF
	
	//warning out of range
	IF NOT IS_CAR_DEAD rcp_playerplane
		IF NOT IS_CAR_IN_AREA_2D rcp_playerplane 833.0 1340.0 -225.0 -1666.0 FALSE
			IF IS_CAR_IN_AREA_2D rcp_playerplane 940.212 1340.225 -253.15 -1700.0  FALSE
				PRINT_NOW ( RCPL1_8 ) 3000 1
			ENDIF
		ENDIF
	ENDIF

	//out of range
	IF NOT IS_CAR_DEAD rcp_playerplane
		IF NOT IS_CAR_IN_AREA_2D rcp_playerplane 940.212 1340.225 -253.15 -1700.0 FALSE
			BLOW_UP_RC_BUGGY
			PRINT_NOW ( RCPL1_9 ) 5000 1
			GOTO mission_rcplane_failed
		ENDIF
	ENDIF
	


ENDWHILE

GOTO mission_rcplane_passed	   		


///////////////////////////////////////////////
rcp_get_next_checkpoint:///////////////////////////
///////////////////////////////////////////////

	IF rcp_gosub_cpcounter = 0
		rcp_gosub_cp_x = rcp_cp1_x
		rcp_gosub_cp_y = rcp_cp1_y
		rcp_gosub_cp_z = rcp_cp1_z
		rcp_gosub_cp_2nd_x = rcp_cp2_x
		rcp_gosub_cp_2nd_y = rcp_cp2_y
		rcp_gosub_cp_2nd_z = rcp_cp2_z
	ENDIF

	IF rcp_gosub_cpcounter = 1
		rcp_gosub_cp_x = rcp_cp2_x
		rcp_gosub_cp_y = rcp_cp2_y
		rcp_gosub_cp_z = rcp_cp2_z
		rcp_gosub_cp_2nd_x = rcp_cp3_x
		rcp_gosub_cp_2nd_y = rcp_cp3_y
		rcp_gosub_cp_2nd_z = rcp_cp3_z
	ENDIF

	IF rcp_gosub_cpcounter = 2
		rcp_gosub_cp_x = rcp_cp3_x
		rcp_gosub_cp_y = rcp_cp3_y
		rcp_gosub_cp_z = rcp_cp3_z
		rcp_gosub_cp_2nd_x = rcp_cp4_x
		rcp_gosub_cp_2nd_y = rcp_cp4_y
		rcp_gosub_cp_2nd_z = rcp_cp4_z
	ENDIF

	IF rcp_gosub_cpcounter = 3
		rcp_gosub_cp_x = rcp_cp4_x
		rcp_gosub_cp_y = rcp_cp4_y
		rcp_gosub_cp_z = rcp_cp4_z
		rcp_gosub_cp_2nd_x = rcp_cp5_x
		rcp_gosub_cp_2nd_y = rcp_cp5_y
		rcp_gosub_cp_2nd_z = rcp_cp5_z
	ENDIF

	IF rcp_gosub_cpcounter = 4
		rcp_gosub_cp_x = rcp_cp5_x
		rcp_gosub_cp_y = rcp_cp5_y
		rcp_gosub_cp_z = rcp_cp5_z
		rcp_gosub_cp_2nd_x = rcp_cp6_x
		rcp_gosub_cp_2nd_y = rcp_cp6_y
		rcp_gosub_cp_2nd_z = rcp_cp6_z
	ENDIF

	IF rcp_gosub_cpcounter = 5
		rcp_gosub_cp_x = rcp_cp6_x
		rcp_gosub_cp_y = rcp_cp6_y
		rcp_gosub_cp_z = rcp_cp6_z
		rcp_gosub_cp_2nd_x = rcp_cp7_x
		rcp_gosub_cp_2nd_y = rcp_cp7_y
		rcp_gosub_cp_2nd_z = rcp_cp7_z
	ENDIF

	IF rcp_gosub_cpcounter = 6
		rcp_gosub_cp_x = rcp_cp7_x
		rcp_gosub_cp_y = rcp_cp7_y
		rcp_gosub_cp_z = rcp_cp7_z
		rcp_gosub_cp_2nd_x = rcp_cp8_x
		rcp_gosub_cp_2nd_y = rcp_cp8_y
		rcp_gosub_cp_2nd_z = rcp_cp8_z
	ENDIF

	IF rcp_gosub_cpcounter = 7
		rcp_gosub_cp_x = rcp_cp8_x
		rcp_gosub_cp_y = rcp_cp8_y
		rcp_gosub_cp_z = rcp_cp8_z
		rcp_gosub_cp_2nd_x = rcp_cp9_x
		rcp_gosub_cp_2nd_y = rcp_cp9_y
		rcp_gosub_cp_2nd_z = rcp_cp9_z
	ENDIF

	IF rcp_gosub_cpcounter = 8
		rcp_gosub_cp_x = rcp_cp9_x
		rcp_gosub_cp_y = rcp_cp9_y
		rcp_gosub_cp_z = rcp_cp9_z
		rcp_gosub_cp_2nd_x = rcp_cp10_x
		rcp_gosub_cp_2nd_y = rcp_cp10_y
		rcp_gosub_cp_2nd_z = rcp_cp10_z
	ENDIF

	IF rcp_gosub_cpcounter = 9
		rcp_gosub_cp_x = rcp_cp10_x
		rcp_gosub_cp_y = rcp_cp10_y
		rcp_gosub_cp_z = rcp_cp10_z
		rcp_gosub_cp_2nd_x = rcp_cp11_x
		rcp_gosub_cp_2nd_y = rcp_cp11_y
		rcp_gosub_cp_2nd_z = rcp_cp11_z
	ENDIF

	IF rcp_gosub_cpcounter = 10
		rcp_gosub_cp_x = rcp_cp11_x
		rcp_gosub_cp_y = rcp_cp11_y
		rcp_gosub_cp_z = rcp_cp11_z
		rcp_gosub_cp_2nd_x = rcp_cp12_x
		rcp_gosub_cp_2nd_y = rcp_cp12_y
		rcp_gosub_cp_2nd_z = rcp_cp12_z
	ENDIF

	IF rcp_gosub_cpcounter = 11
		rcp_gosub_cp_x = rcp_cp12_x
		rcp_gosub_cp_y = rcp_cp12_y
		rcp_gosub_cp_z = rcp_cp12_z
		rcp_gosub_cp_2nd_x = rcp_cp13_x
		rcp_gosub_cp_2nd_y = rcp_cp13_y
		rcp_gosub_cp_2nd_z = rcp_cp13_z
	ENDIF

	IF rcp_gosub_cpcounter = 12
		rcp_gosub_cp_x = rcp_cp13_x
		rcp_gosub_cp_y = rcp_cp13_y
		rcp_gosub_cp_z = rcp_cp13_z
		rcp_gosub_cp_2nd_x = rcp_cp14_x
		rcp_gosub_cp_2nd_y = rcp_cp14_y
		rcp_gosub_cp_2nd_z = rcp_cp14_z
	ENDIF

	IF rcp_gosub_cpcounter = 13
		rcp_gosub_cp_x = rcp_cp14_x
		rcp_gosub_cp_y = rcp_cp14_y
		rcp_gosub_cp_z = rcp_cp14_z
		rcp_gosub_cp_2nd_x = rcp_cp15_x
		rcp_gosub_cp_2nd_y = rcp_cp15_y
		rcp_gosub_cp_2nd_z = rcp_cp15_z
	ENDIF

	IF rcp_gosub_cpcounter = 14
		rcp_gosub_cp_x = rcp_cp15_x
		rcp_gosub_cp_y = rcp_cp15_y
		rcp_gosub_cp_z = rcp_cp15_z
		rcp_gosub_cp_2nd_x = rcp_cp16_x
		rcp_gosub_cp_2nd_y = rcp_cp16_y
		rcp_gosub_cp_2nd_z = rcp_cp16_z
	ENDIF

	IF rcp_gosub_cpcounter = 15
		rcp_gosub_cp_x = rcp_cp16_x
		rcp_gosub_cp_y = rcp_cp16_y
		rcp_gosub_cp_z = rcp_cp16_z
		rcp_gosub_cp_2nd_x = rcp_cp17_x
		rcp_gosub_cp_2nd_y = rcp_cp17_y
		rcp_gosub_cp_2nd_z = rcp_cp17_z
	ENDIF

	IF rcp_gosub_cpcounter = 16
		rcp_gosub_cp_x = rcp_cp17_x
		rcp_gosub_cp_y = rcp_cp17_y
		rcp_gosub_cp_z = rcp_cp17_z
		rcp_gosub_cp_2nd_x = rcp_cp18_x
		rcp_gosub_cp_2nd_y = rcp_cp18_y
		rcp_gosub_cp_2nd_z = rcp_cp18_z
	ENDIF

	IF rcp_gosub_cpcounter = 17
		rcp_gosub_cp_x = rcp_cp18_x
		rcp_gosub_cp_y = rcp_cp18_y
		rcp_gosub_cp_z = rcp_cp18_z
		rcp_gosub_cp_2nd_x = rcp_cp19_x
		rcp_gosub_cp_2nd_y = rcp_cp19_y
		rcp_gosub_cp_2nd_z = rcp_cp19_z
	ENDIF

	IF rcp_gosub_cpcounter = 18
		rcp_gosub_cp_x = rcp_cp19_x
		rcp_gosub_cp_y = rcp_cp19_y
		rcp_gosub_cp_z = rcp_cp19_z
		rcp_gosub_cp_2nd_x = rcp_cp20_x
		rcp_gosub_cp_2nd_y = rcp_cp20_y
		rcp_gosub_cp_2nd_z = rcp_cp20_z
	ENDIF

	IF rcp_gosub_cpcounter = 19
		rcp_gosub_cp_x = rcp_cp20_x
		rcp_gosub_cp_y = rcp_cp20_y
		rcp_gosub_cp_z = rcp_cp20_z
		rcp_gosub_cp_2nd_x = rcp_cp21_x
		rcp_gosub_cp_2nd_y = rcp_cp21_y
		rcp_gosub_cp_2nd_z = rcp_cp21_z
	ENDIF

	IF rcp_gosub_cpcounter = 20
		rcp_gosub_cp_x = rcp_cp21_x
		rcp_gosub_cp_y = rcp_cp21_y
		rcp_gosub_cp_z = rcp_cp21_z
		rcp_gosub_cp_2nd_x = rcp_cp22_x
		rcp_gosub_cp_2nd_y = rcp_cp22_y
		rcp_gosub_cp_2nd_z = rcp_cp22_z
	ENDIF

	IF rcp_gosub_cpcounter = 21
		rcp_gosub_cp_x = rcp_cp22_x
		rcp_gosub_cp_y = rcp_cp22_y
		rcp_gosub_cp_z = rcp_cp22_z
		rcp_gosub_cp_2nd_x = rcp_cp23_x
		rcp_gosub_cp_2nd_y = rcp_cp23_y
		rcp_gosub_cp_2nd_z = rcp_cp23_z
	ENDIF

	IF rcp_gosub_cpcounter = 22
		rcp_gosub_cp_x = rcp_cp23_x
		rcp_gosub_cp_y = rcp_cp23_y
		rcp_gosub_cp_z = rcp_cp23_z
		rcp_gosub_cp_2nd_x = rcp_cp24_x
		rcp_gosub_cp_2nd_y = rcp_cp24_y
		rcp_gosub_cp_2nd_z = rcp_cp24_z
	ENDIF

	IF rcp_gosub_cpcounter = 23
		rcp_gosub_cp_x = rcp_cp24_x
		rcp_gosub_cp_y = rcp_cp24_y
		rcp_gosub_cp_z = rcp_cp24_z
		rcp_gosub_cp_2nd_x = rcp_cp25_x
		rcp_gosub_cp_2nd_y = rcp_cp25_y
		rcp_gosub_cp_2nd_z = rcp_cp25_z
	ENDIF

	IF rcp_gosub_cpcounter = 24
		rcp_gosub_cp_x = rcp_cp25_x
		rcp_gosub_cp_y = rcp_cp25_y
		rcp_gosub_cp_z = rcp_cp25_z
		rcp_gosub_cp_2nd_x = rcp_cp26_x
		rcp_gosub_cp_2nd_y = rcp_cp26_y
		rcp_gosub_cp_2nd_z = rcp_cp26_z
	ENDIF

	IF rcp_gosub_cpcounter = 25
		rcp_gosub_cp_x = rcp_cp26_x
		rcp_gosub_cp_y = rcp_cp26_y
		rcp_gosub_cp_z = rcp_cp26_z
		rcp_gosub_cp_2nd_x = rcp_cp27_x
		rcp_gosub_cp_2nd_y = rcp_cp27_y
		rcp_gosub_cp_2nd_z = rcp_cp27_z
	ENDIF

	IF rcp_gosub_cpcounter = 26
		rcp_gosub_cp_x = rcp_cp27_x
		rcp_gosub_cp_y = rcp_cp27_y
		rcp_gosub_cp_z = rcp_cp27_z
		rcp_gosub_cp_2nd_x = rcp_cp28_x
		rcp_gosub_cp_2nd_y = rcp_cp28_y
		rcp_gosub_cp_2nd_z = rcp_cp28_z
	ENDIF

	IF rcp_gosub_cpcounter = 27
		rcp_gosub_cp_x = rcp_cp28_x
		rcp_gosub_cp_y = rcp_cp28_y
		rcp_gosub_cp_z = rcp_cp28_z
		rcp_gosub_cp_2nd_x = rcp_cp29_x
		rcp_gosub_cp_2nd_y = rcp_cp29_y
		rcp_gosub_cp_2nd_z = rcp_cp29_z
	ENDIF

	IF rcp_gosub_cpcounter = 28
		rcp_gosub_cp_x = rcp_cp29_x
		rcp_gosub_cp_y = rcp_cp29_y
		rcp_gosub_cp_z = rcp_cp29_z
		rcp_gosub_cp_2nd_x = rcp_cp29_x
		rcp_gosub_cp_2nd_y = rcp_cp29_y
		rcp_gosub_cp_2nd_z = rcp_cp29_z
	ENDIF

///////////////////////////////////////////////
RETURN/////////////////////////////////////////
///////////////////////////////////////////////


///////////////////////////////////////////////
rcp_race_plane_stuck_checks://////////////////////////////
///////////////////////////////////////////////

GET_CAR_HEALTH rcp_gosub_race_plane rcp_plane_health
IF rcp_plane_health < 500
	SET_CAR_HEALTH rcp_gosub_race_plane 1000
ENDIF

IF NOT IS_CAR_DEAD rcp_playerplane
	IF rcp_player_cpcounter	= rcp_gosub_cpcounter	
		GET_CAR_COORDINATES	rcp_gosub_race_plane rcp_plane_x rcp_plane_y rcp_plane_z
		rcp_difference_x_float_d = rcp_plane_x - rcp_player1_cp_x
		rcp_difference_y_float_d = rcp_plane_y - rcp_player1_cp_y
		rcp_difference_x_float_d = rcp_difference_x_float_d * rcp_difference_x_float_d
		rcp_difference_y_float_d = rcp_difference_y_float_d * rcp_difference_y_float_d
		rcp_sum_difference_d_xy = rcp_difference_x_float_d + rcp_difference_y_float_d
		SQRT rcp_sum_difference_d_xy rcp_plane_distance_from_cp

		GET_CAR_COORDINATES rcp_playerplane rcp_plane_x rcp_plane_y rcp_plane_z
		rcp_difference_x_float_d = rcp_plane_x - rcp_player1_cp_x
		rcp_difference_y_float_d = rcp_plane_y - rcp_player1_cp_y
		rcp_difference_x_float_d = rcp_difference_x_float_d * rcp_difference_x_float_d
		rcp_difference_y_float_d = rcp_difference_y_float_d * rcp_difference_y_float_d
		rcp_sum_difference_d_xy = rcp_difference_x_float_d + rcp_difference_y_float_d
		SQRT rcp_sum_difference_d_xy rcp_player1_distance_from_cp

		IF rcp_player1_distance_from_cp > rcp_plane_distance_from_cp
			++ rcp_position
		ENDIF
	ELSE
		IF rcp_player_cpcounter < rcp_gosub_cpcounter
			++ rcp_position
		ENDIF
	ENDIF
ENDIF


//IF NOT IS_CAR_DEAD rcp_gosub_race_plane
//	IF NOT LOCATE_CAR_3D rcp_gosub_race_plane rcp_plane_stuck_x rcp_plane_stuck_y rcp_plane_stuck_z 3.0 3.0 2.0 0
//		GET_CAR_COORDINATES rcp_gosub_race_plane rcp_plane_stuck_x rcp_plane_stuck_y rcp_plane_stuck_z
//		rcp_timer_started = rcp_game_time
//	ENDIF
//ENDIF
//
//IF NOT IS_CAR_DEAD rcp_gosub_race_plane
//	IF LOCATE_CAR_3D rcp_gosub_race_plane rcp_plane_stuck_x rcp_plane_stuck_y rcp_plane_stuck_z 3.0 3.0 2.0 0
//		rcp_stuck_timer = rcp_game_time - rcp_timer_started
//		IF rcp_stuck_timer > 4000
//			IF NOT IS_CAR_ON_SCREEN rcp_gosub_race_plane
//				GET_CAR_COORDINATES rcp_gosub_race_plane rcp_plane_x rcp_plane_y rcp_plane_z
//				GET_CLOSEST_CAR_NODE rcp_plane_x rcp_plane_y rcp_plane_z rcp_plane_x rcp_plane_y rcp_plane_z
//				IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY rcp_plane_x rcp_plane_y rcp_plane_z 4.0 4.0 3.0
//					IF NOT IS_POINT_ON_SCREEN rcp_plane_x rcp_plane_y rcp_plane_z 4.0
//						SET_CAR_COORDINATES rcp_gosub_race_plane rcp_plane_x rcp_plane_y rcp_plane_z
//						TURN_CAR_TO_FACE_COORD rcp_gosub_race_plane rcp_plane3_cp_x rcp_plane3_cp_y
//						rcp_timer_reset_flag = 0
//					ENDIF
//				ENDIF
//			ENDIF
//		ENDIF
//	ENDIF
//ENDIF

///////////////////////////////////////////////
RETURN/////////////////////////////////////////
///////////////////////////////////////////////

mission_rcplane_failed:
PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed"
ALTER_WANTED_LEVEL player1 rcplane_wanted_level
RETURN

   

// **************************************** mission haitian3 passed ************************

mission_rcplane_passed:
//flag_rcplane_passed = 1
//REGISTER_MISSION_PASSED ( )

/// Works out time in mins and seconds
race_timer_seconds_plane1 = rcp_race_timer / 1000 //seconds

REGISTER_FASTEST_TIME 3 race_timer_seconds_plane1 

race_timer_mins_plane1 = race_timer_seconds_plane1 / 60 // mins
race_timer_seconds2_plane1 = race_timer_mins_plane1 * 60 
race_timer_seconds_plane1 = race_timer_seconds_plane1 - race_timer_seconds2_plane1 

IF race_timer_seconds_plane1 >= 10
	PRINT_WITH_2_NUMBERS_NOW ( RCH1_9 ) race_timer_mins_plane1 race_timer_seconds_plane1 7000 1 
ELSE
	PRINT_WITH_2_NUMBERS_NOW ( RCH1_10 ) race_timer_mins_plane1 race_timer_seconds_plane1 7000 1
ENDIF

IF playerpassedrcplane1 = 0
	PLAYER_MADE_PROGRESS 1
	REGISTER_ODDJOB_MISSION_PASSED
	playerpassedrcplane1 = 1
ENDIF

ADD_SCORE player1 100
PRINT_WITH_NUMBER_BIG ( M_PASS ) 100 5000 1 //"Mission Passed!"
CLEAR_WANTED_LEVEL player1

PLAY_MISSION_PASSED_TUNE 1
RETURN
		


// ********************************** mission cleanup **************************************

mission_cleanup_rcplane:

flag_player_on_mission = 0
flag_player_on_rc_mission = 0 //PC FIX PC FIX PC FIX PC FIX PC FIX PC FIX PC FIX

CLEAR_ONSCREEN_TIMER rcp_race_timer
REMOVE_BLIP rcp_blip_chase 
REMOVE_BLIP rcp_second_blip 
REMOVE_BLIP rcp_blip_plane1 
REMOVE_BLIP rcp_blip_plane2 
REMOVE_BLIP rcp_blip_plane3
REMOVE_RC_BUGGY
IF NOT IS_CAR_DEAD vanfor_rcplane_race
	LOCK_CAR_DOORS vanfor_rcplane_race CARLOCK_UNLOCKED
ENDIF
MARK_CAR_AS_NO_LONGER_NEEDED vanfor_rcplane_race
MARK_MODEL_AS_NO_LONGER_NEEDED rcbaron
MARK_CAR_AS_NO_LONGER_NEEDED rcp_race_plane1
MARK_CAR_AS_NO_LONGER_NEEDED rcp_race_plane2
MARK_CAR_AS_NO_LONGER_NEEDED rcp_race_plane3
DELETE_CAR rcp_race_plane1
DELETE_CAR rcp_race_plane2
DELETE_CAR rcp_race_plane3
SET_POLICE_IGNORE_PLAYER player1 OFF
has_player_just_done_rcplane_mission = 1
GET_GAME_TIMER timer_mobile_start
MISSION_HAS_FINISHED
RETURN
}