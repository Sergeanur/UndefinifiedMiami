MISSION_START
// *****************************************************************************************
// *********************************** Road Races ******************************************
// *****************************************************************************************
// *** 														 ***
// *****************************************************************************************

// Mission start stuff


{

SCRIPT_NAME RCRACE1

GOSUB mission_rc_races_start

IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_rc_races_failed
ENDIF

GOSUB mission_rc_races_cleanup

MISSION_END
 
// ******************************** Variables for mission **********************************

VAR_FLOAT rc_car_x rc_car_y rc_car_z rc_car_headings
VAR_FLOAT rc_difference_x_float_d rc_difference_y_float_d  rc_sum_difference_d_xy	
VAR_FLOAT rc_car1_locate_size rc_car2_locate_size rc_car3_locate_size
VAR_FLOAT rc_car_distance_from_cp rc_player1_distance_from_cp
VAR_FLOAT rc_road1_x rc_road1_y rc_road1_z rc_road2_x rc_road2_y rc_road2_z

VAR_FLOAT rc_car1_stuck_x rc_car1_stuck_y rc_car1_stuck_z
VAR_FLOAT rc_car2_stuck_x rc_car2_stuck_y rc_car2_stuck_z
VAR_FLOAT rc_car3_stuck_x rc_car3_stuck_y rc_car3_stuck_z
VAR_FLOAT rc_car_stuck_x rc_car_stuck_y rc_car_stuck_z

VAR_FLOAT rc_player1_cp_x rc_player1_cp_y rc_player1_cp_z
VAR_FLOAT rc_blip_2nd_x rc_blip_2nd_y rc_blip_2nd_z
VAR_FLOAT rc_car1_cp_x rc_car1_cp_y rc_car1_cp_z
VAR_FLOAT rc_car2_cp_x rc_car2_cp_y rc_car2_cp_z
VAR_FLOAT rc_car3_cp_x rc_car3_cp_y rc_car3_cp_z

VAR_FLOAT rc_gosub_cp_x rc_gosub_cp_y rc_gosub_cp_z rc_gosub_cp_2nd_x rc_gosub_cp_2nd_y rc_gosub_cp_2nd_z

VAR_INT rc_blip_chase rc_second_blip rc_blip_car1 rc_blip_car2 rc_blip_car3 vanforrcrace
VAR_INT rc_race_car1 rc_race_car2 rc_race_car3 rc_car_health rc_gosub_race_car	rc_playercar
VAR_INT rc_driver_car1 rc_driver_car2 rc_driver_car3
VAR_INT rc_player_cpcounter rc_car1_cpcounter rc_car2_cpcounter rc_car3_cpcounter rc_gosub_cpcounter
VAR_INT rc_position rc_race_timer rc_car1_stuck_timer rc_car2_stuck_timer rc_car3_stuck_timer
VAR_INT rc_race_timer_start rc_timer_started rc_stuck_timer
VAR_INT rc_total_checkpoints rc_total_checkpoints_minus1
VAR_INT rc_game_time
VAR_INT rc_timer_reset_flag previous_wanted_levelrcrace playerpassedrcrace


VAR_FLOAT rc_cp0_x rc_cp0_y rc_cp0_z rc_cp1_x rc_cp1_y rc_cp1_z rc_cp2_x rc_cp2_y rc_cp2_z rc_cp3_x rc_cp3_y rc_cp3_z rc_cp4_x rc_cp4_y rc_cp4_z 
VAR_FLOAT rc_cp5_x rc_cp5_y rc_cp5_z rc_cp6_x rc_cp6_y rc_cp6_z rc_cp7_x rc_cp7_y rc_cp7_z rc_cp8_x rc_cp8_y rc_cp8_z rc_cp9_x rc_cp9_y rc_cp9_z 
VAR_FLOAT rc_cp10_x rc_cp10_y rc_cp10_z rc_cp11_x rc_cp11_y rc_cp11_z rc_cp12_x rc_cp12_y rc_cp12_z rc_cp13_x rc_cp13_y rc_cp13_z 
VAR_FLOAT rc_cp14_x rc_cp14_y rc_cp14_z rc_cp15_x rc_cp15_y rc_cp15_z rc_cp16_x rc_cp16_y rc_cp16_z rc_cp17_x rc_cp17_y rc_cp17_z 
VAR_FLOAT rc_cp18_x rc_cp18_y rc_cp18_z rc_cp19_x rc_cp19_y rc_cp19_z rc_cp20_x rc_cp20_y rc_cp20_z rc_cp21_x rc_cp21_y rc_cp21_z 
VAR_FLOAT rc_cp22_x rc_cp22_y rc_cp22_z rc_cp23_x rc_cp23_y rc_cp23_z rc_cp24_x rc_cp24_y rc_cp24_z rc_cp25_x rc_cp25_y rc_cp25_z
VAR_FLOAT rc_cp26_x rc_cp26_y rc_cp26_z rc_cp27_x rc_cp27_y rc_cp27_z rc_cp28_x rc_cp28_y rc_cp28_z rc_cp29_x rc_cp29_y rc_cp29_z 
VAR_FLOAT rc_cp30_x rc_cp30_y rc_cp30_z rc_cp31_x rc_cp31_y rc_cp31_z rc_cp32_x rc_cp32_y rc_cp32_z rc_cp33_x rc_cp33_y rc_cp33_z
VAR_FLOAT rc_cp34_x rc_cp34_y rc_cp34_z rc_cp35_x rc_cp35_y rc_cp35_z rc_cp36_x rc_cp36_y rc_cp36_z rc_cp37_x rc_cp37_y rc_cp37_z
VAR_FLOAT rc_cp38_x rc_cp38_y rc_cp38_z rc_cp39_x rc_cp39_y rc_cp39_z rc_cp40_x rc_cp40_y rc_cp40_z rc_cp41_x rc_cp41_y rc_cp41_z
VAR_FLOAT rc_cp42_x rc_cp42_y rc_cp42_z rc_cp43_x rc_cp43_y rc_cp43_z rc_cp44_x rc_cp44_y rc_cp44_z rc_cp45_x rc_cp45_y rc_cp45_z 
VAR_FLOAT rc_cp46_x rc_cp46_y rc_cp46_z rc_cp47_x rc_cp47_y rc_cp47_z rc_cp48_x rc_cp48_y rc_cp48_z rc_cp49_x rc_cp49_y rc_cp49_z
VAR_FLOAT rc_cp50_x rc_cp50_y rc_cp50_z


VAR_INT race_timer_seconds_rccar1
VAR_INT race_timer_seconds2_rccar1 
VAR_INT race_timer_mins_rccar1

VAR_INT laps1 laps2 lapstodisplay_rc1

			   
// ************************************ Mission Start **************************************

mission_rc_races_start:

flag_player_on_mission = 1
flag_player_on_rc_mission = 1 //PC FIX PC FIX PC FIX PC FIX PC FIX PC FIX PC FIX


IF playerpassedrcrace = 0
	REGISTER_MISSION_GIVEN
ENDIF


WAIT 0

LOAD_MISSION_TEXT RCRACE1
 


rc_total_checkpoints = 50 

rc_cp0_x = 720.21   //start for player
rc_cp0_y = 723.979
rc_cp0_z = 11.095	  

rc_cp1_x = 772.386
rc_cp1_y = 737.37
rc_cp1_z = 15.651

rc_cp2_x = 801.8997
rc_cp2_y = 755.155
rc_cp2_z = 14.029

rc_cp3_x = 818.443
rc_cp3_y = 723.44672 
rc_cp3_z = 13.891738

rc_cp4_x = 789.737366
rc_cp4_y = 689.696533
rc_cp4_z = 13.684759

rc_cp5_x = 840.728577  
rc_cp5_y = 673.793274
rc_cp5_z = 12.007194
	
rc_cp6_x = 881.608952
rc_cp6_y = 694.430481
rc_cp6_z = 11.477220

rc_cp7_x = 869.666931	
rc_cp7_y = 734.155029	
rc_cp7_z = 18.036583

rc_cp8_x = 857.413269
rc_cp8_y = 775.233521	
rc_cp8_z = 11.757508

rc_cp9_x = 879.892883	
rc_cp9_y = 804.468506
rc_cp9_z = 12.733551

rc_cp10_x = 888.080078
rc_cp10_y = 838.525696
rc_cp10_z = 13.69488

rc_cp11_x = 874.349976
rc_cp11_y = 866.943298
rc_cp11_z = 13.128591
 
rc_cp12_x = 815.803162
rc_cp12_y = 881.502014
rc_cp12_z = 11.895948
 
rc_cp13_x = 808.499695
rc_cp13_y = 851.382385
rc_cp13_z = 9.721323

rc_cp14_x = 824.736877
rc_cp14_y = 827.109314
rc_cp14_z = 8.638121

rc_cp15_x = 795.352356
rc_cp15_y = 821.603394
rc_cp15_z = 10.476272

rc_cp16_x = 766.222908
rc_cp16_y = 835.067078
rc_cp16_z = 12.008146

rc_cp17_x = 750.055298
rc_cp17_y = 882.093689
rc_cp17_z = 13.639874

rc_cp18_x = 726.083496
rc_cp18_y = 840.016296
rc_cp18_z = 14.142872

rc_cp19_x = 756.243835
rc_cp19_y = 792.235535
rc_cp19_z = 17.651541

rc_cp20_x = 727.599548
rc_cp20_y = 775.997925
rc_cp20_z = 11.351994

rc_cp21_x = 700.173645
rc_cp21_y = 800.755737
rc_cp21_z = 12.544271

rc_cp22_x = 673.115417
rc_cp22_y = 831.915222
rc_cp22_z = 14.805586

rc_cp23_x = 672.152771
rc_cp23_y = 798.628239
rc_cp23_z = 12.678308

rc_cp24_x = 692.794983
rc_cp24_y = 761.659912
rc_cp24_z = 10.672594

rc_cp25_x = 741.042297
rc_cp25_y = 716.250732
rc_cp25_z = 11.225778

///

rc_cp26_x = 772.386
rc_cp26_y = 737.37
rc_cp26_z = 15.651

rc_cp27_x = 801.8997
rc_cp27_y = 755.155
rc_cp27_z = 14.029

rc_cp28_x = 818.443
rc_cp28_y = 723.44672 
rc_cp28_z = 13.891738

rc_cp29_x = 789.737366
rc_cp29_y = 689.696533
rc_cp29_z = 13.684759

rc_cp30_x = 840.728577  
rc_cp30_y = 673.793274
rc_cp30_z = 12.007194
	
rc_cp31_x = 881.608952
rc_cp31_y = 694.430481
rc_cp31_z = 11.477220

rc_cp32_x = 869.666931	
rc_cp32_y = 734.155029	
rc_cp32_z = 18.036583

rc_cp33_x = 857.413269
rc_cp33_y = 775.233521	
rc_cp33_z = 11.757508

rc_cp34_x = 879.892883	
rc_cp34_y = 804.468506
rc_cp34_z = 12.733551

rc_cp35_x = 888.080078
rc_cp35_y = 838.525696
rc_cp35_z = 13.69488

rc_cp36_x = 874.349976
rc_cp36_y = 866.943298
rc_cp36_z = 13.128591
 
rc_cp37_x = 815.803162
rc_cp37_y = 881.502014
rc_cp37_z = 11.895948
 
rc_cp38_x = 808.499695
rc_cp38_y = 851.382385
rc_cp38_z = 9.721323

rc_cp39_x = 824.736877
rc_cp39_y = 827.109314
rc_cp39_z = 8.638121

rc_cp40_x = 795.352356
rc_cp40_y = 821.603394
rc_cp40_z = 10.476272

rc_cp41_x = 766.222908
rc_cp41_y = 835.067078
rc_cp41_z = 12.008146

rc_cp42_x = 750.055298
rc_cp42_y = 882.093689
rc_cp42_z = 13.639874

rc_cp43_x = 726.083496
rc_cp43_y = 840.016296
rc_cp43_z = 14.142872

rc_cp44_x = 756.243835
rc_cp44_y = 792.235535
rc_cp44_z = 17.651541

rc_cp45_x = 727.599548
rc_cp45_y = 775.997925
rc_cp45_z = 11.351994

rc_cp46_x = 700.173645
rc_cp46_y = 800.755737
rc_cp46_z = 12.544271

rc_cp47_x = 673.115417
rc_cp47_y = 831.915222
rc_cp47_z = 14.805586

rc_cp48_x = 672.152771
rc_cp48_y = 798.628239
rc_cp48_z = 12.678308

rc_cp49_x = 692.794983
rc_cp49_y = 761.659912
rc_cp49_z = 10.672594

rc_cp50_x = 741.042297
rc_cp50_y = 716.250732
rc_cp50_z = 11.225778




rc_car1_stuck_x = 740.8333
rc_car1_stuck_y = 721.5853 
rc_car1_stuck_z = 11.0126

rc_car2_stuck_x = 740.5471
rc_car2_stuck_y = 718.5853//719.1122
rc_car2_stuck_z = 11.0884

rc_car3_stuck_x = 740.2183
rc_car3_stuck_y = 715.5853//715.8696
rc_car3_stuck_z = 11.1233

rc_car_headings = 262.9725

rc_gosub_cpcounter   = 0
rc_player_cpcounter  = 0
rc_car1_cpcounter 	 = 0
rc_car2_cpcounter 	 = 0
rc_car3_cpcounter 	 = 0
rc_car1_locate_size  = 3.5
rc_car2_locate_size  = 3.5
rc_car3_locate_size  = 3.5

race_timer_seconds_rccar1 = 0
race_timer_seconds2_rccar1 = 0
race_timer_mins_rccar1 = 0

laps1 = 2
laps2 = 1
lapstodisplay_rc1 = 0


REQUEST_MODEL rcbandit

WHILE NOT HAS_MODEL_LOADED rcbandit
	WAIT 0
ENDWHILE

STORE_WANTED_LEVEL player1 previous_wanted_levelrcrace
SET_POLICE_IGNORE_PLAYER player1 ON
CLEAR_WANTED_LEVEL player1
STORE_CAR_PLAYER_IS_IN player1 vanforrcrace
STORE_WANTED_LEVEL player1 previous_wanted_levelrcrace

				   
CLEAR_AREA 757.152 811.371 500.0 500.0 TRUE

SET_PLAYER_CONTROL player1 OFF
SWITCH_WIDESCREEN ON
GIVE_REMOTE_CONTROLLED_CAR_TO_PLAYER player1 739.9240 712.5853 11.1484 262.9725
GET_REMOTE_CONTROLLED_CAR player1 rc_playercar
SET_ENABLE_RC_DETONATE_ON_CONTACT FALSE 
CHANGE_CAR_COLOUR rc_playercar CARCOLOUR_MIDNIGHTBLUE CARCOLOUR_WHITE

CREATE_CAR rcbandit rc_car1_stuck_x rc_car1_stuck_y rc_car1_stuck_z rc_race_car1
CHANGE_CAR_COLOUR rc_race_car1 CARCOLOUR_CHERRYRED CARCOLOUR_WHITE
SET_CAR_STRONG rc_race_car1 TRUE
SET_UPSIDEDOWN_CAR_NOT_DAMAGED rc_race_car1 TRUE
SET_CAR_HEADING rc_race_car1 rc_car_headings
CAR_SET_IDLE rc_race_car1
SET_CAR_DRIVING_STYLE rc_race_car1 2
SET_CAR_CRUISE_SPEED rc_race_car1 26.0
SET_CAR_ONLY_DAMAGED_BY_PLAYER rc_race_car1 TRUE
SET_CAR_STRAIGHT_LINE_DISTANCE rc_race_car1 1

CREATE_CAR rcbandit rc_car2_stuck_x rc_car2_stuck_y rc_car2_stuck_z rc_race_car2
CHANGE_CAR_COLOUR rc_race_car2 CARCOLOUR_POLICECARBLUE CARCOLOUR_WHITE
SET_CAR_STRONG rc_race_car2 TRUE
SET_UPSIDEDOWN_CAR_NOT_DAMAGED rc_race_car2 TRUE
SET_CAR_HEADING rc_race_car2 rc_car_headings
CAR_SET_IDLE rc_race_car2
SET_CAR_DRIVING_STYLE rc_race_car2 2
SET_CAR_CRUISE_SPEED rc_race_car2 20.0
SET_CAR_ONLY_DAMAGED_BY_PLAYER rc_race_car2 TRUE
SET_CAR_STRAIGHT_LINE_DISTANCE rc_race_car2 1

CREATE_CAR rcbandit rc_car3_stuck_x rc_car3_stuck_y rc_car3_stuck_z rc_race_car3
CHANGE_CAR_COLOUR rc_race_car3 CARCOLOUR_TAXIYELLOW CARCOLOUR_WHITE
SET_CAR_STRONG rc_race_car3 TRUE
SET_UPSIDEDOWN_CAR_NOT_DAMAGED rc_race_car3 TRUE
SET_CAR_HEADING rc_race_car3 rc_car_headings
CAR_SET_IDLE rc_race_car3
SET_CAR_DRIVING_STYLE rc_race_car3 2
SET_CAR_CRUISE_SPEED rc_race_car3 23.0
SET_CAR_ONLY_DAMAGED_BY_PLAYER rc_race_car3 TRUE
SET_CAR_STRAIGHT_LINE_DISTANCE rc_race_car3 1

SET_FIXED_CAMERA_POSITION 742.290527 724.444946 12.351935 0.0 0.0 0.0 	 //starting line
POINT_CAMERA_AT_POINT 742.166504 723.502808 12.040593 JUMP_CUT

SET_TIME_OF_DAY 10 00
FORCE_WEATHER_NOW WEATHER_EXTRA_SUNNY

DO_FADE 2000 FADE_IN

WHILE GET_FADING_STATUS
 	WAIT 0
ENDWHILE


	TIMERA = 0
	
	WHILE TIMERA < 5000
	   			   
	WAIT 0
	 
	PRINT_NOW ( RCR1_1 ) 5000 2
		 					
	IF IS_BUTTON_PRESSED PAD1 cross
		GOTO endrcracecut
	ENDIF

	ENDWHILE

	SET_FIXED_CAMERA_POSITION 893.181517 624.383301 41.499504 0.0 0.0 0.0 	 //track
	POINT_CAMERA_AT_POINT 892.674194 625.208435 41.251152 JUMP_CUT
			
	TIMERA = 0

	WHILE TIMERA < 5000
	   			   
	WAIT 0
	 
	PRINT_NOW ( RCR1_2 ) 5000 2
		 					
	IF IS_BUTTON_PRESSED PAD1 cross
		GOTO endrcracecut
	ENDIF

	ENDWHILE

	SET_FIXED_CAMERA_POSITION 743.534424 710.374146 12.714686 0.0 0.0 0.0 	 //final starting line
	POINT_CAMERA_AT_POINT 743.002930 711.205878 12.550325 JUMP_CUT

	TIMERA = 0

	WHILE TIMERA < 5000
	   			   
	WAIT 0
	 
	PRINT_NOW ( RCR1_3 ) 5000 2
		 					
	IF IS_BUTTON_PRESSED PAD1 cross
		GOTO endrcracecut
	ENDIF

	ENDWHILE


endrcracecut:

 	IF NOT IS_CAR_DEAD rc_playercar
		CLEAR_SMALL_PRINTS
	 	POINT_CAMERA_AT_CAR rc_playercar BEHINDCAR JUMP_CUT
		SWITCH_WIDESCREEN OFF
		WAIT 500
	ENDIF

 


// ***************************************************************


rc_race_start:

rc_total_checkpoints_minus1 = rc_total_checkpoints - 1

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

DISPLAY_ONSCREEN_COUNTER_WITH_STRING laps1 COUNTER_DISPLAY_NUMBER ( RCR1_4 )

IF IS_CAR_DEAD rc_race_car1
	GOTO mission_rc_races_failed
ENDIF

IF IS_CAR_DEAD rc_race_car2
	GOTO mission_rc_races_failed
ENDIF

IF IS_CAR_DEAD rc_race_car3
	GOTO mission_rc_races_failed
ENDIF

//IF NOT IS_CAR_DEAD rc_race_car1
//	ADD_BLIP_FOR_CAR_OLD rc_race_car1 RED MARKER_ONLY rc_blip_car1
//ENDIF		
//
//IF NOT IS_CAR_DEAD rc_race_car2
//	ADD_BLIP_FOR_CAR_OLD rc_race_car2 RED MARKER_ONLY rc_blip_car2
//ENDIF			
//
//IF NOT IS_CAR_DEAD rc_race_car3
//	ADD_BLIP_FOR_CAR_OLD rc_race_car3 RED MARKER_ONLY rc_blip_car3
//ENDIF

GOSUB rc_get_next_checkpoint
rc_player1_cp_x = rc_gosub_cp_x
rc_player1_cp_y = rc_gosub_cp_y
rc_player1_cp_z = rc_gosub_cp_z
rc_blip_2nd_x = rc_gosub_cp_2nd_x
rc_blip_2nd_y = rc_gosub_cp_2nd_y
rc_blip_2nd_z = rc_gosub_cp_2nd_z

rc_car1_cp_x = rc_gosub_cp_x
rc_car1_cp_y = rc_gosub_cp_y
rc_car1_cp_z = rc_gosub_cp_z

rc_car2_cp_x = rc_gosub_cp_x
rc_car2_cp_y = rc_gosub_cp_y
rc_car2_cp_z = rc_gosub_cp_z

rc_car3_cp_x = rc_gosub_cp_x
rc_car3_cp_y = rc_gosub_cp_y
rc_car3_cp_z = rc_gosub_cp_z

ADD_BLIP_FOR_COORD rc_player1_cp_x rc_player1_cp_y rc_player1_cp_z rc_blip_chase

ADD_BLIP_FOR_COORD_OLD rc_blip_2nd_x rc_blip_2nd_y rc_blip_2nd_z PURPLE BLIP_ONLY rc_second_blip

DIM_BLIP rc_second_blip TRUE
CAR_GOTO_COORDINATES rc_race_car1 rc_car1_cp_x rc_car1_cp_y rc_car1_cp_z
CAR_GOTO_COORDINATES rc_race_car2 rc_car2_cp_x rc_car2_cp_y rc_car2_cp_z
CAR_GOTO_COORDINATES rc_race_car3 rc_car3_cp_x rc_car3_cp_y rc_car3_cp_z

rc_race_timer = 0
DISPLAY_ONSCREEN_TIMER_WITH_STRING rc_race_timer TIMER_UP ( RCH1_5 )

IF IS_CAR_DEAD rc_playercar
	GOTO mission_rc_races_failed
ENDIF

 
WHILE rc_player_cpcounter < rc_total_checkpoints

	WAIT 0

	CLEAR_AREA -447.80 1442.95 10.0 120.0 TRUE
		 	
	rc_position = 0

   
	IF NOT IS_CAR_DEAD rc_playercar
		IF LOCATE_CAR_2D rc_playercar rc_player1_cp_x rc_player1_cp_y 4.2 4.2 FALSE
			
			++ rc_player_cpcounter
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
					   
			REMOVE_BLIP rc_blip_chase
			REMOVE_BLIP rc_second_blip
			
			rc_gosub_cpcounter = rc_player_cpcounter
			GOSUB rc_get_next_checkpoint
			rc_player1_cp_x = rc_gosub_cp_x
			rc_player1_cp_y = rc_gosub_cp_y
			rc_player1_cp_z = rc_gosub_cp_z
			rc_blip_2nd_x = rc_gosub_cp_2nd_x
			rc_blip_2nd_y = rc_gosub_cp_2nd_y
			rc_blip_2nd_z = rc_gosub_cp_2nd_z
			
			IF rc_player_cpcounter = rc_total_checkpoints
				GOTO mission_rc_races_passed		
			ENDIF


//			IF rc_player_cpcounter = 25 
//				PRINT_BIG ( RCRC1_3 ) 5000 2
//			ENDIF

			ADD_BLIP_FOR_COORD rc_player1_cp_x rc_player1_cp_y rc_player1_cp_z rc_blip_chase

			IF NOT rc_player_cpcounter = rc_total_checkpoints_minus1
				ADD_BLIP_FOR_COORD_OLD rc_blip_2nd_x rc_blip_2nd_y rc_blip_2nd_z PURPLE BLIP_ONLY rc_second_blip
				DIM_BLIP rc_second_blip ON
				CHANGE_BLIP_SCALE rc_second_blip 2
			ENDIF

		ENDIF
	ENDIF
			
	IF NOT IS_CAR_DEAD rc_race_car1
		
		rc_gosub_race_car = rc_race_car1
		rc_gosub_cpcounter = rc_car1_cpcounter
		rc_car_stuck_x = rc_car1_stuck_x
		rc_car_stuck_y = rc_car1_stuck_y
		rc_car_stuck_z = rc_car1_stuck_z
		rc_timer_started = rc_car1_stuck_timer
		GOSUB rc_race_car_stuck_checks
		rc_car1_stuck_x = rc_car_stuck_x
		rc_car1_stuck_y = rc_car_stuck_y
		rc_car1_stuck_z = rc_car_stuck_z
		rc_car1_stuck_timer = rc_timer_started
		
		IF NOT IS_CAR_DEAD rc_race_car1
			IF LOCATE_CAR_2D rc_race_car1 rc_car1_cp_x rc_car1_cp_y rc_car1_locate_size rc_car1_locate_size 0
										
				++ rc_car1_cpcounter
				rc_gosub_cpcounter = rc_car1_cpcounter
				GOSUB rc_get_next_checkpoint
				rc_car1_cp_x = rc_gosub_cp_x
				rc_car1_cp_y = rc_gosub_cp_y
				rc_car1_cp_z = rc_gosub_cp_z
				
//				IF rc_car1_cpcounter = 17
//					rc_car1_locate_size = 6.0
//				ENDIF

				IF rc_car1_cpcounter = rc_total_checkpoints
					PRINT_NOW ( RACEFA ) 5000 1 //"~r~You failed to win the race!"
					GOTO mission_rc_races_failed		
				ENDIF
				
				IF rc_car1_locate_size = 7.0
					CAR_GOTO_COORDINATES rc_race_car1 rc_car1_cp_x rc_car1_cp_y rc_car1_cp_z
				ELSE
					CAR_GOTO_COORDINATES_ACCURATE rc_race_car1 rc_car1_cp_x rc_car1_cp_y rc_car1_cp_z
				ENDIF
			ENDIF
		ENDIF
	ENDIF


	IF NOT IS_CAR_DEAD rc_race_car2

		rc_gosub_race_car = rc_race_car2
		rc_gosub_cpcounter = rc_car2_cpcounter
		rc_car_stuck_x = rc_car2_stuck_x
		rc_car_stuck_y = rc_car2_stuck_y
		rc_car_stuck_z = rc_car2_stuck_z
		rc_timer_started = rc_car2_stuck_timer
		GOSUB rc_race_car_stuck_checks
		rc_car2_stuck_x = rc_car_stuck_x
		rc_car2_stuck_y = rc_car_stuck_y
		rc_car2_stuck_z = rc_car_stuck_z
		rc_car2_stuck_timer = rc_timer_started

		IF NOT IS_CAR_DEAD rc_race_car2
			IF LOCATE_CAR_2D rc_race_car2 rc_car2_cp_x rc_car2_cp_y rc_car2_locate_size rc_car2_locate_size 0
		   
				++ rc_car2_cpcounter
				rc_gosub_cpcounter = rc_car2_cpcounter
				GOSUB rc_get_next_checkpoint
				rc_car2_cp_x = rc_gosub_cp_x
				rc_car2_cp_y = rc_gosub_cp_y
				rc_car2_cp_z = rc_gosub_cp_z

//				IF rc_car2_cpcounter = 17
//					rc_car2_locate_size = 6.0
//				ENDIF

				IF rc_car2_cpcounter = rc_total_checkpoints
					PRINT_NOW ( RACEFA ) 5000 1 //"~r~You failed to win the race!"
					GOTO mission_rc_races_failed		
				ENDIF
				
				IF rc_car2_locate_size = 7.0
					CAR_GOTO_COORDINATES rc_race_car2 rc_car2_cp_x rc_car2_cp_y rc_car2_cp_z
				ELSE
					CAR_GOTO_COORDINATES_ACCURATE rc_race_car2 rc_car2_cp_x rc_car2_cp_y rc_car2_cp_z
				ENDIF
			ENDIF
		ENDIF
	ENDIF


	IF NOT IS_CAR_DEAD rc_race_car3
		
		rc_gosub_race_car = rc_race_car3
		rc_gosub_cpcounter = rc_car3_cpcounter
		rc_car_stuck_x = rc_car3_stuck_x
		rc_car_stuck_y = rc_car3_stuck_y
		rc_car_stuck_z = rc_car3_stuck_z
		rc_timer_started = rc_car3_stuck_timer
		GOSUB rc_race_car_stuck_checks
		rc_car3_stuck_x = rc_car_stuck_x
		rc_car3_stuck_y = rc_car_stuck_y
		rc_car3_stuck_z = rc_car_stuck_z
		rc_car3_stuck_timer = rc_timer_started

		IF NOT IS_CAR_DEAD rc_race_car3
			IF LOCATE_CAR_2D rc_race_car3 rc_car3_cp_x rc_car3_cp_y rc_car3_locate_size rc_car3_locate_size 0
		

				++ rc_car3_cpcounter
				rc_gosub_cpcounter = rc_car3_cpcounter
				GOSUB rc_get_next_checkpoint
				rc_car3_cp_x = rc_gosub_cp_x
				rc_car3_cp_y = rc_gosub_cp_y
				rc_car3_cp_z = rc_gosub_cp_z
				
//				IF rc_car3_cpcounter = 17
//					rc_car3_locate_size = 6.0
//				ENDIF
				
				IF rc_car3_cpcounter = rc_total_checkpoints
					PRINT_NOW ( RACEFA ) 5000 1 //"~r~You failed to win the race!"
					GOTO mission_rc_races_failed		
				ENDIF

				IF rc_car3_locate_size = 7.0
					CAR_GOTO_COORDINATES rc_race_car3 rc_car3_cp_x rc_car3_cp_y rc_car3_cp_z 
				ELSE
					CAR_GOTO_COORDINATES_ACCURATE rc_race_car3 rc_car3_cp_x rc_car3_cp_y rc_car3_cp_z 
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF rc_position = 0
		PRINT_NOW FIRST 100 1 //"1st"
	ENDIF

	IF rc_position = 1
		PRINT_NOW SECOND 100 1 //"2nd"
	ENDIF

	IF rc_position = 2
		PRINT_NOW THIRD 100 1 //"3rd"
	ENDIF

	IF rc_position = 3
		PRINT_NOW FOURTH 100 1 //"4th"
	ENDIF

	IF rc_player_cpcounter = rc_total_checkpoints_minus1
		DRAW_WEAPONSHOP_CORONA rc_player1_cp_x rc_player1_cp_y rc_player1_cp_z 3.8 CORONATYPE_CIRCLE FLARETYPE_NONE 100 5 5
	ELSE
		DRAW_WEAPONSHOP_CORONA rc_player1_cp_x rc_player1_cp_y rc_player1_cp_z 3.8 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	ENDIF

	IF IS_CAR_DEAD rc_playercar
		GOTO mission_rc_races_failed
	ENDIF

	//display number of laps
	IF rc_player_cpcounter > 24 
		IF lapstodisplay_rc1 = 0
			CLEAR_ONSCREEN_COUNTER laps1
			DISPLAY_ONSCREEN_COUNTER_WITH_STRING laps2 COUNTER_DISPLAY_NUMBER ( RCR1_4 )
			lapstodisplay_rc1 = 1
		ENDIF
	ENDIF

	/////////////////////////////////////////////////////////RANGE

	IF NOT IS_CAR_DEAD rc_playercar
		IF NOT IS_CAR_IN_AREA_2D rc_playercar 595.94 930.07 950.085 606.168 FALSE
			IF IS_CAR_IN_AREA_2D rc_playercar 473.016 1102.161 939.0 217.567 FALSE
				PRINT_NOW ( RCR1_6 ) 3000 1
			ENDIF
		ENDIF
	ENDIF

	//out of range
	IF NOT IS_CAR_DEAD rc_playercar
		IF NOT IS_CAR_IN_AREA_2D rc_playercar 473.016 1102.161 939.0 217.567 FALSE
			BLOW_UP_RC_BUGGY
			PRINT_NOW ( RCR1_7 ) 5000 1
			GOTO mission_rc_races_failed
		ENDIF
	ENDIF


ENDWHILE




GOTO mission_rc_races_passed	   		

	
// Mission races failed

mission_rc_races_failed:
PRINT_BIG M_FAIL 2000 1
RETURN

   

// mission races passed

mission_rc_races_passed:

//flag_rcplane_passed = 1
//REGISTER_MISSION_PASSED ( )

/// Works out time in mins and seconds
race_timer_seconds_rccar1 = rc_race_timer / 1000 //seconds

REGISTER_FASTEST_TIME 4 race_timer_seconds_rccar1 

race_timer_mins_rccar1 = race_timer_seconds_rccar1 / 60 // mins
race_timer_seconds2_rccar1 = race_timer_mins_rccar1 * 60 
race_timer_seconds_rccar1 = race_timer_seconds_rccar1 - race_timer_seconds2_rccar1 

IF race_timer_seconds_rccar1 >= 10
	PRINT_WITH_2_NUMBERS_NOW ( RCH1_9 ) race_timer_mins_rccar1 race_timer_seconds_rccar1 7000 1 
ELSE
	PRINT_WITH_2_NUMBERS_NOW ( RCH1_10 ) race_timer_mins_rccar1 race_timer_seconds_rccar1 7000 1
ENDIF

IF playerpassedrcrace = 0
	PLAYER_MADE_PROGRESS 1
	REGISTER_ODDJOB_MISSION_PASSED
	playerpassedrcrace = 1
ENDIF
 
ADD_SCORE player1 100
PRINT_WITH_NUMBER_BIG M_PASS 100 5000 1
CLEAR_WANTED_LEVEL player1
PLAY_MISSION_PASSED_TUNE 1
 
RETURN
		

// mission cleanup

mission_rc_races_cleanup:
REMOVE_RC_BUGGY
//REMOVE_BLIP rc_blip_car1
//REMOVE_BLIP rc_blip_car2
//REMOVE_BLIP rc_blip_car3
REMOVE_BLIP rc_blip_chase
REMOVE_BLIP rc_second_blip
MARK_MODEL_AS_NO_LONGER_NEEDED rcbandit
DELETE_CAR rc_race_car1
DELETE_CAR rc_race_car2
DELETE_CAR rc_race_car3
CLEAR_ONSCREEN_TIMER rc_race_timer
flag_player_on_mission = 0
flag_player_on_rc_mission = 0 //PC FIX PC FIX PC FIX PC FIX PC FIX PC FIX PC FIX
has_player_just_done_rcrace_mission = 1
SET_ENABLE_RC_DETONATE_ON_CONTACT TRUE 
SET_POLICE_IGNORE_PLAYER player1 OFF
CLEAR_ONSCREEN_COUNTER laps1
CLEAR_ONSCREEN_COUNTER laps2
RELEASE_WEATHER
MISSION_HAS_FINISHED
RETURN
		
}

///////////////////////////////////////////////
rc_get_next_checkpoint:///////////////////////////
///////////////////////////////////////////////

	IF rc_gosub_cpcounter = 0
		rc_gosub_cp_x = rc_cp1_x
		rc_gosub_cp_y = rc_cp1_y
		rc_gosub_cp_z = rc_cp1_z
		rc_gosub_cp_2nd_x = rc_cp2_x
		rc_gosub_cp_2nd_y = rc_cp2_y
		rc_gosub_cp_2nd_z = rc_cp2_z
	ENDIF

	IF rc_gosub_cpcounter = 1
		rc_gosub_cp_x = rc_cp2_x
		rc_gosub_cp_y = rc_cp2_y
		rc_gosub_cp_z = rc_cp2_z
		rc_gosub_cp_2nd_x = rc_cp3_x
		rc_gosub_cp_2nd_y = rc_cp3_y
		rc_gosub_cp_2nd_z = rc_cp3_z
	ENDIF

	IF rc_gosub_cpcounter = 2
		rc_gosub_cp_x = rc_cp3_x
		rc_gosub_cp_y = rc_cp3_y
		rc_gosub_cp_z = rc_cp3_z
		rc_gosub_cp_2nd_x = rc_cp4_x
		rc_gosub_cp_2nd_y = rc_cp4_y
		rc_gosub_cp_2nd_z = rc_cp4_z
	ENDIF

	IF rc_gosub_cpcounter = 3
		rc_gosub_cp_x = rc_cp4_x
		rc_gosub_cp_y = rc_cp4_y
		rc_gosub_cp_z = rc_cp4_z
		rc_gosub_cp_2nd_x = rc_cp5_x
		rc_gosub_cp_2nd_y = rc_cp5_y
		rc_gosub_cp_2nd_z = rc_cp5_z
	ENDIF

	IF rc_gosub_cpcounter = 4
		rc_gosub_cp_x = rc_cp5_x
		rc_gosub_cp_y = rc_cp5_y
		rc_gosub_cp_z = rc_cp5_z
		rc_gosub_cp_2nd_x = rc_cp6_x
		rc_gosub_cp_2nd_y = rc_cp6_y
		rc_gosub_cp_2nd_z = rc_cp6_z
	ENDIF

	IF rc_gosub_cpcounter = 5
		rc_gosub_cp_x = rc_cp6_x
		rc_gosub_cp_y = rc_cp6_y
		rc_gosub_cp_z = rc_cp6_z
		rc_gosub_cp_2nd_x = rc_cp7_x
		rc_gosub_cp_2nd_y = rc_cp7_y
		rc_gosub_cp_2nd_z = rc_cp7_z
	ENDIF

	IF rc_gosub_cpcounter = 6
		rc_gosub_cp_x = rc_cp7_x
		rc_gosub_cp_y = rc_cp7_y
		rc_gosub_cp_z = rc_cp7_z
		rc_gosub_cp_2nd_x = rc_cp8_x
		rc_gosub_cp_2nd_y = rc_cp8_y
		rc_gosub_cp_2nd_z = rc_cp8_z
	ENDIF

	IF rc_gosub_cpcounter = 7
		rc_gosub_cp_x = rc_cp8_x
		rc_gosub_cp_y = rc_cp8_y
		rc_gosub_cp_z = rc_cp8_z
		rc_gosub_cp_2nd_x = rc_cp9_x
		rc_gosub_cp_2nd_y = rc_cp9_y
		rc_gosub_cp_2nd_z = rc_cp9_z
	ENDIF

	IF rc_gosub_cpcounter = 8
		rc_gosub_cp_x = rc_cp9_x
		rc_gosub_cp_y = rc_cp9_y
		rc_gosub_cp_z = rc_cp9_z
		rc_gosub_cp_2nd_x = rc_cp10_x
		rc_gosub_cp_2nd_y = rc_cp10_y
		rc_gosub_cp_2nd_z = rc_cp10_z
	ENDIF

	IF rc_gosub_cpcounter = 9
		rc_gosub_cp_x = rc_cp10_x
		rc_gosub_cp_y = rc_cp10_y
		rc_gosub_cp_z = rc_cp10_z
		rc_gosub_cp_2nd_x = rc_cp11_x
		rc_gosub_cp_2nd_y = rc_cp11_y
		rc_gosub_cp_2nd_z = rc_cp11_z
	ENDIF

	IF rc_gosub_cpcounter = 10
		rc_gosub_cp_x = rc_cp11_x
		rc_gosub_cp_y = rc_cp11_y
		rc_gosub_cp_z = rc_cp11_z
		rc_gosub_cp_2nd_x = rc_cp12_x
		rc_gosub_cp_2nd_y = rc_cp12_y
		rc_gosub_cp_2nd_z = rc_cp12_z
	ENDIF

	IF rc_gosub_cpcounter = 11
		rc_gosub_cp_x = rc_cp12_x
		rc_gosub_cp_y = rc_cp12_y
		rc_gosub_cp_z = rc_cp12_z
		rc_gosub_cp_2nd_x = rc_cp13_x
		rc_gosub_cp_2nd_y = rc_cp13_y
		rc_gosub_cp_2nd_z = rc_cp13_z
	ENDIF

	IF rc_gosub_cpcounter = 12
		rc_gosub_cp_x = rc_cp13_x
		rc_gosub_cp_y = rc_cp13_y
		rc_gosub_cp_z = rc_cp13_z
		rc_gosub_cp_2nd_x = rc_cp14_x
		rc_gosub_cp_2nd_y = rc_cp14_y
		rc_gosub_cp_2nd_z = rc_cp14_z
	ENDIF

	IF rc_gosub_cpcounter = 13
		rc_gosub_cp_x = rc_cp14_x
		rc_gosub_cp_y = rc_cp14_y
		rc_gosub_cp_z = rc_cp14_z
		rc_gosub_cp_2nd_x = rc_cp15_x
		rc_gosub_cp_2nd_y = rc_cp15_y
		rc_gosub_cp_2nd_z = rc_cp15_z
	ENDIF

	IF rc_gosub_cpcounter = 14
		rc_gosub_cp_x = rc_cp15_x
		rc_gosub_cp_y = rc_cp15_y
		rc_gosub_cp_z = rc_cp15_z
		rc_gosub_cp_2nd_x = rc_cp16_x
		rc_gosub_cp_2nd_y = rc_cp16_y
		rc_gosub_cp_2nd_z = rc_cp16_z
	ENDIF

	IF rc_gosub_cpcounter = 15
		rc_gosub_cp_x = rc_cp16_x
		rc_gosub_cp_y = rc_cp16_y
		rc_gosub_cp_z = rc_cp16_z
		rc_gosub_cp_2nd_x = rc_cp17_x
		rc_gosub_cp_2nd_y = rc_cp17_y
		rc_gosub_cp_2nd_z = rc_cp17_z
	ENDIF

	IF rc_gosub_cpcounter = 16
		rc_gosub_cp_x = rc_cp17_x
		rc_gosub_cp_y = rc_cp17_y
		rc_gosub_cp_z = rc_cp17_z
		rc_gosub_cp_2nd_x = rc_cp18_x
		rc_gosub_cp_2nd_y = rc_cp18_y
		rc_gosub_cp_2nd_z = rc_cp18_z
	ENDIF

	IF rc_gosub_cpcounter = 17
		rc_gosub_cp_x = rc_cp18_x
		rc_gosub_cp_y = rc_cp18_y
		rc_gosub_cp_z = rc_cp18_z
		rc_gosub_cp_2nd_x = rc_cp19_x
		rc_gosub_cp_2nd_y = rc_cp19_y
		rc_gosub_cp_2nd_z = rc_cp19_z
	ENDIF

	IF rc_gosub_cpcounter = 18
		rc_gosub_cp_x = rc_cp19_x
		rc_gosub_cp_y = rc_cp19_y
		rc_gosub_cp_z = rc_cp19_z
		rc_gosub_cp_2nd_x = rc_cp20_x
		rc_gosub_cp_2nd_y = rc_cp20_y
		rc_gosub_cp_2nd_z = rc_cp20_z
	ENDIF

	IF rc_gosub_cpcounter = 19
		rc_gosub_cp_x = rc_cp20_x
		rc_gosub_cp_y = rc_cp20_y
		rc_gosub_cp_z = rc_cp20_z
		rc_gosub_cp_2nd_x = rc_cp21_x
		rc_gosub_cp_2nd_y = rc_cp21_y
		rc_gosub_cp_2nd_z = rc_cp21_z
	ENDIF

	IF rc_gosub_cpcounter = 20
		rc_gosub_cp_x = rc_cp21_x
		rc_gosub_cp_y = rc_cp21_y
		rc_gosub_cp_z = rc_cp21_z
		rc_gosub_cp_2nd_x = rc_cp22_x
		rc_gosub_cp_2nd_y = rc_cp22_y
		rc_gosub_cp_2nd_z = rc_cp22_z
	ENDIF

	IF rc_gosub_cpcounter = 21
		rc_gosub_cp_x = rc_cp22_x
		rc_gosub_cp_y = rc_cp22_y
		rc_gosub_cp_z = rc_cp22_z
		rc_gosub_cp_2nd_x = rc_cp23_x
		rc_gosub_cp_2nd_y = rc_cp23_y
		rc_gosub_cp_2nd_z = rc_cp23_z
	ENDIF

	IF rc_gosub_cpcounter = 22
		rc_gosub_cp_x = rc_cp23_x
		rc_gosub_cp_y = rc_cp23_y
		rc_gosub_cp_z = rc_cp23_z
		rc_gosub_cp_2nd_x = rc_cp24_x
		rc_gosub_cp_2nd_y = rc_cp24_y
		rc_gosub_cp_2nd_z = rc_cp24_z
	ENDIF

	IF rc_gosub_cpcounter = 23
		rc_gosub_cp_x = rc_cp24_x
		rc_gosub_cp_y = rc_cp24_y
		rc_gosub_cp_z = rc_cp24_z
		rc_gosub_cp_2nd_x = rc_cp25_x
		rc_gosub_cp_2nd_y = rc_cp25_y
		rc_gosub_cp_2nd_z = rc_cp25_z
	ENDIF

	IF rc_gosub_cpcounter = 24
		rc_gosub_cp_x = rc_cp25_x
		rc_gosub_cp_y = rc_cp25_y
		rc_gosub_cp_z = rc_cp25_z
		rc_gosub_cp_2nd_x = rc_cp26_x
		rc_gosub_cp_2nd_y = rc_cp26_y
		rc_gosub_cp_2nd_z = rc_cp26_z
	ENDIF

	IF rc_gosub_cpcounter = 25
		rc_gosub_cp_x = rc_cp26_x
		rc_gosub_cp_y = rc_cp26_y
		rc_gosub_cp_z = rc_cp26_z
		rc_gosub_cp_2nd_x = rc_cp27_x
		rc_gosub_cp_2nd_y = rc_cp27_y
		rc_gosub_cp_2nd_z = rc_cp27_z
	ENDIF

	IF rc_gosub_cpcounter = 26
		rc_gosub_cp_x = rc_cp27_x
		rc_gosub_cp_y = rc_cp27_y
		rc_gosub_cp_z = rc_cp27_z
		rc_gosub_cp_2nd_x = rc_cp28_x
		rc_gosub_cp_2nd_y = rc_cp28_y
		rc_gosub_cp_2nd_z = rc_cp28_z
	ENDIF

	IF rc_gosub_cpcounter = 27
		rc_gosub_cp_x = rc_cp28_x
		rc_gosub_cp_y = rc_cp28_y
		rc_gosub_cp_z = rc_cp28_z
		rc_gosub_cp_2nd_x = rc_cp29_x
		rc_gosub_cp_2nd_y = rc_cp29_y
		rc_gosub_cp_2nd_z = rc_cp29_z
	ENDIF

	IF rc_gosub_cpcounter = 28
		rc_gosub_cp_x = rc_cp29_x
		rc_gosub_cp_y = rc_cp29_y
		rc_gosub_cp_z = rc_cp29_z
		rc_gosub_cp_2nd_x = rc_cp30_x
		rc_gosub_cp_2nd_y = rc_cp30_y
		rc_gosub_cp_2nd_z = rc_cp30_z
	ENDIF

	IF rc_gosub_cpcounter = 29
		rc_gosub_cp_x = rc_cp30_x
		rc_gosub_cp_y = rc_cp30_y
		rc_gosub_cp_z = rc_cp30_z
		rc_gosub_cp_2nd_x = rc_cp31_x
		rc_gosub_cp_2nd_y = rc_cp31_y
		rc_gosub_cp_2nd_z = rc_cp31_z
	ENDIF

	IF rc_gosub_cpcounter = 30
		rc_gosub_cp_x = rc_cp31_x
		rc_gosub_cp_y = rc_cp31_y
		rc_gosub_cp_z = rc_cp31_z
		rc_gosub_cp_2nd_x = rc_cp32_x
		rc_gosub_cp_2nd_y = rc_cp32_y
		rc_gosub_cp_2nd_z = rc_cp32_z
	ENDIF

	IF rc_gosub_cpcounter = 31
		rc_gosub_cp_x = rc_cp32_x
		rc_gosub_cp_y = rc_cp32_y
		rc_gosub_cp_z = rc_cp32_z
		rc_gosub_cp_2nd_x = rc_cp33_x
		rc_gosub_cp_2nd_y = rc_cp33_y
		rc_gosub_cp_2nd_z = rc_cp33_z
	ENDIF

	IF rc_gosub_cpcounter = 32
		rc_gosub_cp_x = rc_cp33_x
		rc_gosub_cp_y = rc_cp33_y
		rc_gosub_cp_z = rc_cp33_z
		rc_gosub_cp_2nd_x = rc_cp34_x
		rc_gosub_cp_2nd_y = rc_cp34_y
		rc_gosub_cp_2nd_z = rc_cp34_z
	ENDIF

	IF rc_gosub_cpcounter = 33
		rc_gosub_cp_x = rc_cp34_x
		rc_gosub_cp_y = rc_cp34_y
		rc_gosub_cp_z = rc_cp34_z
		rc_gosub_cp_2nd_x = rc_cp35_x
		rc_gosub_cp_2nd_y = rc_cp35_y
		rc_gosub_cp_2nd_z = rc_cp35_z
	ENDIF

	IF rc_gosub_cpcounter = 34
		rc_gosub_cp_x = rc_cp35_x
		rc_gosub_cp_y = rc_cp35_y
		rc_gosub_cp_z = rc_cp35_z
		rc_gosub_cp_2nd_x = rc_cp36_x
		rc_gosub_cp_2nd_y = rc_cp36_y
		rc_gosub_cp_2nd_z = rc_cp36_z
	ENDIF

	IF rc_gosub_cpcounter = 35
		rc_gosub_cp_x = rc_cp36_x
		rc_gosub_cp_y = rc_cp36_y
		rc_gosub_cp_z = rc_cp36_z
		rc_gosub_cp_2nd_x = rc_cp37_x
		rc_gosub_cp_2nd_y = rc_cp37_y
		rc_gosub_cp_2nd_z = rc_cp37_z
	ENDIF

	IF rc_gosub_cpcounter = 36
		rc_gosub_cp_x = rc_cp37_x
		rc_gosub_cp_y = rc_cp37_y
		rc_gosub_cp_z = rc_cp37_z
		rc_gosub_cp_2nd_x = rc_cp38_x
		rc_gosub_cp_2nd_y = rc_cp38_y
		rc_gosub_cp_2nd_z = rc_cp38_z
	ENDIF

	IF rc_gosub_cpcounter = 37
		rc_gosub_cp_x = rc_cp38_x
		rc_gosub_cp_y = rc_cp38_y
		rc_gosub_cp_z = rc_cp38_z
		rc_gosub_cp_2nd_x = rc_cp39_x
		rc_gosub_cp_2nd_y = rc_cp39_y
		rc_gosub_cp_2nd_z = rc_cp39_z
	ENDIF

	IF rc_gosub_cpcounter = 38
		rc_gosub_cp_x = rc_cp39_x
		rc_gosub_cp_y = rc_cp39_y
		rc_gosub_cp_z = rc_cp39_z
		rc_gosub_cp_2nd_x = rc_cp40_x
		rc_gosub_cp_2nd_y = rc_cp40_y
		rc_gosub_cp_2nd_z = rc_cp40_z
	ENDIF

	IF rc_gosub_cpcounter = 39
		rc_gosub_cp_x = rc_cp40_x
		rc_gosub_cp_y = rc_cp40_y
		rc_gosub_cp_z = rc_cp40_z
		rc_gosub_cp_2nd_x = rc_cp41_x
		rc_gosub_cp_2nd_y = rc_cp41_y
		rc_gosub_cp_2nd_z = rc_cp41_z
	ENDIF

	IF rc_gosub_cpcounter = 40
		rc_gosub_cp_x = rc_cp41_x
		rc_gosub_cp_y = rc_cp41_y
		rc_gosub_cp_z = rc_cp41_z
		rc_gosub_cp_2nd_x = rc_cp42_x
		rc_gosub_cp_2nd_y = rc_cp42_y
		rc_gosub_cp_2nd_z = rc_cp42_z
	ENDIF

	IF rc_gosub_cpcounter = 41
		rc_gosub_cp_x = rc_cp42_x
		rc_gosub_cp_y = rc_cp42_y
		rc_gosub_cp_z = rc_cp42_z
		rc_gosub_cp_2nd_x = rc_cp43_x
		rc_gosub_cp_2nd_y = rc_cp43_y
		rc_gosub_cp_2nd_z = rc_cp43_z
	ENDIF

	IF rc_gosub_cpcounter = 42
		rc_gosub_cp_x = rc_cp43_x
		rc_gosub_cp_y = rc_cp43_y
		rc_gosub_cp_z = rc_cp43_z
		rc_gosub_cp_2nd_x = rc_cp44_x
		rc_gosub_cp_2nd_y = rc_cp44_y
		rc_gosub_cp_2nd_z = rc_cp44_z
	ENDIF

	IF rc_gosub_cpcounter = 43
		rc_gosub_cp_x = rc_cp44_x
		rc_gosub_cp_y = rc_cp44_y
		rc_gosub_cp_z = rc_cp44_z
		rc_gosub_cp_2nd_x = rc_cp45_x
		rc_gosub_cp_2nd_y = rc_cp45_y
		rc_gosub_cp_2nd_z = rc_cp45_z
	ENDIF

	IF rc_gosub_cpcounter = 44
		rc_gosub_cp_x = rc_cp45_x
		rc_gosub_cp_y = rc_cp45_y
		rc_gosub_cp_z = rc_cp45_z
		rc_gosub_cp_2nd_x = rc_cp46_x
		rc_gosub_cp_2nd_y = rc_cp46_y
		rc_gosub_cp_2nd_z = rc_cp46_z
	ENDIF

	IF rc_gosub_cpcounter = 45
		rc_gosub_cp_x = rc_cp46_x
		rc_gosub_cp_y = rc_cp46_y
		rc_gosub_cp_z = rc_cp46_z
		rc_gosub_cp_2nd_x = rc_cp47_x
		rc_gosub_cp_2nd_y = rc_cp47_y
		rc_gosub_cp_2nd_z = rc_cp47_z
	ENDIF

	IF rc_gosub_cpcounter = 46
		rc_gosub_cp_x = rc_cp47_x
		rc_gosub_cp_y = rc_cp47_y
		rc_gosub_cp_z = rc_cp47_z
		rc_gosub_cp_2nd_x = rc_cp48_x
		rc_gosub_cp_2nd_y = rc_cp48_y
		rc_gosub_cp_2nd_z = rc_cp48_z
	ENDIF

	IF rc_gosub_cpcounter = 47
		rc_gosub_cp_x = rc_cp48_x
		rc_gosub_cp_y = rc_cp48_y
		rc_gosub_cp_z = rc_cp48_z
		rc_gosub_cp_2nd_x = rc_cp49_x
		rc_gosub_cp_2nd_y = rc_cp49_y
		rc_gosub_cp_2nd_z = rc_cp49_z
	ENDIF

	IF rc_gosub_cpcounter = 48
		rc_gosub_cp_x = rc_cp49_x
		rc_gosub_cp_y = rc_cp49_y
		rc_gosub_cp_z = rc_cp49_z
		rc_gosub_cp_2nd_x = rc_cp50_x
		rc_gosub_cp_2nd_y = rc_cp50_y
		rc_gosub_cp_2nd_z = rc_cp50_z
	ENDIF

	IF rc_gosub_cpcounter = 49
		rc_gosub_cp_x = rc_cp50_x
		rc_gosub_cp_y = rc_cp50_y
		rc_gosub_cp_z = rc_cp50_z
		rc_gosub_cp_2nd_x = rc_cp50_x
		rc_gosub_cp_2nd_y = rc_cp50_y
		rc_gosub_cp_2nd_z = rc_cp50_z
	ENDIF
  	
//	IF rc_gosub_cpcounter = 49
//		rc_gosub_cp_x = rc_cp50_x
//		rc_gosub_cp_y = rc_cp50_y
//		rc_gosub_cp_z = rc_cp50_z
//		rc_gosub_cp_2nd_x = rc_cp50_x
//		rc_gosub_cp_2nd_y = rc_cp50_y
//		rc_gosub_cp_2nd_z = rc_cp50_z
//	ENDIF


///////////////////////////////////////////////
RETURN/////////////////////////////////////////
///////////////////////////////////////////////


///////////////////////////////////////////////
rc_race_car_stuck_checks://////////////////////////////
///////////////////////////////////////////////

GET_CAR_HEALTH rc_gosub_race_car rc_car_health
IF rc_car_health < 500
	SET_CAR_HEALTH rc_gosub_race_car 1000
ENDIF

IF NOT IS_CAR_DEAD rc_playercar
	IF rc_player_cpcounter	= rc_gosub_cpcounter	
		GET_CAR_COORDINATES	rc_gosub_race_car rc_car_x rc_car_y rc_car_z
		rc_difference_x_float_d = rc_car_x - rc_player1_cp_x
		rc_difference_y_float_d = rc_car_y - rc_player1_cp_y
		rc_difference_x_float_d = rc_difference_x_float_d * rc_difference_x_float_d
		rc_difference_y_float_d = rc_difference_y_float_d * rc_difference_y_float_d
		rc_sum_difference_d_xy = rc_difference_x_float_d + rc_difference_y_float_d
		SQRT rc_sum_difference_d_xy rc_car_distance_from_cp

		GET_CAR_COORDINATES rc_playercar rc_car_x rc_car_y rc_car_z
		rc_difference_x_float_d = rc_car_x - rc_player1_cp_x
		rc_difference_y_float_d = rc_car_y - rc_player1_cp_y
		rc_difference_x_float_d = rc_difference_x_float_d * rc_difference_x_float_d
		rc_difference_y_float_d = rc_difference_y_float_d * rc_difference_y_float_d
		rc_sum_difference_d_xy = rc_difference_x_float_d + rc_difference_y_float_d
		SQRT rc_sum_difference_d_xy rc_player1_distance_from_cp

		IF rc_player1_distance_from_cp > rc_car_distance_from_cp
			++ rc_position
		ENDIF
	ELSE
		IF rc_player_cpcounter < rc_gosub_cpcounter
			++ rc_position
		ENDIF
	ENDIF
ENDIF


//IF NOT IS_CAR_DEAD rc_gosub_race_car
//	IF NOT LOCATE_CAR_3D rc_gosub_race_car rc_car_stuck_x rc_car_stuck_y rc_car_stuck_z 3.0 3.0 2.0 0
//		GET_CAR_COORDINATES rc_gosub_race_car rc_car_stuck_x rc_car_stuck_y rc_car_stuck_z
//		rc_timer_started = rc_game_time
//	ENDIF
//ENDIF
//
//IF NOT IS_CAR_DEAD rc_gosub_race_car
//	IF LOCATE_CAR_3D rc_gosub_race_car rc_car_stuck_x rc_car_stuck_y rc_car_stuck_z 3.0 3.0 2.0 0
//		rc_stuck_timer = rc_game_time - rc_timer_started
//		IF rc_stuck_timer > 4000
//			IF NOT IS_CAR_ON_SCREEN rc_gosub_race_car
//				GET_CAR_COORDINATES rc_gosub_race_car rc_car_x rc_car_y rc_car_z
//				GET_CLOSEST_CAR_NODE rc_car_x rc_car_y rc_car_z rc_car_x rc_car_y rc_car_z
//				IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY rc_car_x rc_car_y rc_car_z 4.0 4.0 3.0
//					IF NOT IS_POINT_ON_SCREEN rc_car_x rc_car_y rc_car_z 4.0
//						SET_CAR_COORDINATES rc_gosub_race_car rc_car_x rc_car_y rc_car_z
//						TURN_CAR_TO_FACE_COORD rc_gosub_race_car rc_car3_cp_x rc_car3_cp_y
//						rc_timer_reset_flag = 0
//					ENDIF
//				ENDIF
//			ENDIF
//		ENDIF
//	ENDIF
//ENDIF

///////////////////////////////////////////////
RETURN/////////////////////////////////////////
///////////////////////////////////////////////



