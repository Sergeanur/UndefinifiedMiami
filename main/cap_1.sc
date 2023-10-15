MISSION_START
// *****************************************************************************************
// ********************************* Finale mission 1 ************************************** 
// ******************************** Cap the Collectors *************************************
// *****************************************************************************************
// *** The player1 gets a pager message to go to the print works. There he finds the 	 ***
// *** lovely old man beaten up. Some mob collector turned up, got heavy, and left with  ***
// *** some cash.  The mob has started taxing the business.	 The player1 flies into a 	 ***
// *** rage and goes to track down the mob collector.									 ***
// *****************************************************************************************

// Mission start stuff

GOSUB mission_start_finale1

IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_finale1_failed
ENDIF

GOSUB mission_cleanup_finale1

MISSION_END
 
// Variables for mission

//PEDS CARS ETC
VAR_INT collector collector_car	collector_dude1
VAR_INT collector1 collector1_car collector1_dude1
VAR_INT collector2 collector2_car collector2_dude1
VAR_INT collector3 collector3_car collector3_dude1
//BLIPS
VAR_INT	collector1_blip collector2_blip collector3_blip 
VAR_INT icecream_blip taxifirm_blip boatyard_blip showroom_blip malibu_blip porn_blip
//FLAGS TIMERS COUNTERS
VAR_INT	malibu_done	boatyard_done showroom_done porn_done icecream_done taxifirm_done
VAR_INT range_int done_bike_cutscene no_obj_timer
VAR_INT first_batch_done second_batch_done first_batch_lost second_batch_lost
VAR_INT icecream_cash_pickup_removed taxifirm_cash_pickup_removed boatyard_cash_pickup_removed
VAR_INT malibu_cash_pickup_removed showroom_cash_pickup_removed porn_cash_pickup_removed
VAR_INT player_audio_timer player_audio_flag collector_audio_timer collector_audio_flag	max_passengers
VAR_INT collector_counter collector_in_car collector_stuck_timer collector_car_goto_coords_timer collector_cash	collector_in_car_timer
VAR_INT collector1_counter collector1_in_car collector1_stuck_timer collector1_car_goto_coords_timer collector1_cash	collector1_in_car_timer
VAR_INT collector2_counter collector2_in_car collector2_stuck_timer collector2_car_goto_coords_timer collector2_cash	collector2_in_car_timer	collector2_flag
VAR_INT collector3_counter collector3_in_car collector3_stuck_timer collector3_car_goto_coords_timer collector3_cash	collector3_in_car_timer	collector3_flag
//COORD MATHS
VAR_FLOAT collector_goto_x collector_goto_y	collector_goto_z collector_stuck_x collector_stuck_y

//LOAD_AND_LAUNCH_MISSION_EXCLUSIVE stuff
//VAR_INT timer game_timer cutscene_timer
//VAR_FLOAT car_x car_y car_z heading	coord_1_x coord_1_y coord_1_z coord_2_x	coord_2_y
//VAR_INT audio_1_flag audio_2_flag audio_3_flag audio_4_flag audio_5_flag
//VAR_INT audio_6_flag audio_7_flag audio_8_flag audio_9_flag audio_10_flag
//VAR_INT audio_11_flag is_audio_in_use print_timer
//VAR_INT audio_1_timeout audio_2_timeout audio_3_timeout audio_4_timeout audio_5_timeout
//VAR_INT audio_6_timeout audio_7_timeout audio_8_timeout audio_9_timeout audio_10_timeout
//VAR_INT audio_11_timeout gosub_ped num_of_followers	

// ****************************************Mission Start************************************

mission_start_finale1:

flag_player_on_mission = 1

REGISTER_MISSION_GIVEN
SCRIPT_NAME CAP_1

WAIT 0
{
LVAR_FLOAT collector1_goto_x collector1_goto_y collector1_goto_z collector1_stuck_x collector1_stuck_y
LVAR_FLOAT collector2_goto_x collector2_goto_y collector2_goto_z collector2_stuck_x collector2_stuck_y
LVAR_FLOAT collector3_goto_x collector3_goto_y collector3_goto_z collector3_stuck_x collector3_stuck_y

LOAD_MISSION_TEXT CAP_1
SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION -1045.726 -292.454 9.758 97.607  // On road outside of Print Works

//malibu_asset_acquired = 1 //debug!!!!!!
//porn_asset_acquired	= 1 //debug!!!!!
//icecream_asset_acquired = 1 //debug!!!!!!!
//taxifirm_asset_acquired = 1 //debug!!!!!!!
//boatyard_asset_acquired = 1 //debug!!!!!!
//showroom_asset_acquired = 1 //debug!!!!!

collector = -1
collector_car = -1
collector_dude1 = -1
collector_counter = 0
collector_in_car = 0
collector_stuck_timer = 0
collector_car_goto_coords_timer = 0
collector_cash = 0
collector_in_car_timer = 0
collector_goto_x = 0.0
collector_goto_y = 0.0
collector_goto_z = 0.0
collector_stuck_x = 0.0
collector_stuck_y = 0.0

collector1 = -1
collector1_car = -1
collector1_dude1 = -1
collector1_counter = 0
collector1_in_car = 0
collector1_stuck_timer = 0
collector1_car_goto_coords_timer = 0
collector1_cash = 0
collector1_in_car_timer = 0
collector1_goto_x = 0.0
collector1_goto_y = 0.0
collector1_goto_z = 0.0
collector1_stuck_x = 0.0
collector1_stuck_y = 0.0

collector2 = -1
collector2_car = -1
collector2_dude1 = -1
collector2_counter = 0
collector2_in_car = 0
collector2_stuck_timer = 0
collector2_car_goto_coords_timer = 0
collector2_cash = 0
collector2_in_car_timer = 0
collector2_goto_x = 0.0
collector2_goto_y = 0.0
collector2_goto_z = 0.0
collector2_stuck_x = 0.0
collector2_stuck_y = 0.0

collector3 = -1
collector3_car = -1
collector3_dude1 = -1
collector3_counter = 0
collector3_in_car = 0
collector3_stuck_timer = 0
collector3_car_goto_coords_timer = 0
collector3_cash = 0
collector3_in_car_timer = 0
collector3_goto_x = 0.0
collector3_goto_y = 0.0
collector3_goto_z = 0.0
collector3_stuck_x = 0.0
collector3_stuck_y = 0.0

malibu_done	= 0
boatyard_done = 0
showroom_done = 0
porn_done = 0
icecream_done = 0
taxifirm_done = 0

range_int = 0

first_batch_done = 0
second_batch_done = 0
first_batch_lost = 0
second_batch_lost = 0

icecream_cash_pickup_removed = 0
taxifirm_cash_pickup_removed = 0
boatyard_cash_pickup_removed = 0
malibu_cash_pickup_removed = 0
showroom_cash_pickup_removed = 0
porn_cash_pickup_removed = 0

done_bike_cutscene = 0

is_audio_in_use = 0
audio_1_flag = 0
audio_2_flag = 0 
audio_3_flag = 0
audio_4_flag = 0
audio_5_flag = 0
audio_6_flag = 0
audio_7_flag = 0
audio_8_flag = 0
audio_9_flag = 0
audio_10_flag = 0
audio_11_flag = 0

player_audio_timer = 0
player_audio_flag = 0
collector_audio_timer = 0
collector_audio_flag = 0

cutscene_timer = 0

coord_1_x = 0.0
coord_1_y = 0.0
coord_1_z = 0.0

audio_1_timeout = 0
audio_2_timeout = 0 
audio_3_timeout = 0
audio_4_timeout = 0
audio_5_timeout = 0
audio_6_timeout = 0
audio_7_timeout = 0
audio_8_timeout = 0
audio_9_timeout = 0
audio_10_timeout = 0
audio_11_timeout = 0

collector2_flag = 0
collector3_flag = 0

no_obj_timer = 0

/////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////

LOAD_SPECIAL_CHARACTER 1 csplay
LOAD_SPECIAL_CHARACTER 2 cskelly
LOAD_SPECIAL_CHARACTER 3 printra
LOAD_SPECIAL_CHARACTER 4 printrb
LOAD_SPECIAL_CHARACTER 5 printrc

SET_AREA_VISIBLE VIS_PRINT_WORKS
LOAD_SCENE -1071.5597 -278.9497 12.3606

LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_SPECIAL_CHARACTER_LOADED 3
OR NOT HAS_SPECIAL_CHARACTER_LOADED 4
OR NOT HAS_SPECIAL_CHARACTER_LOADED 5
	WAIT 0

ENDWHILE

LOAD_CUTSCENE CAP_1

SET_NEAR_CLIP 0.1

SET_CUTSCENE_OFFSET -1064.103 -276.39 11.066
				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player csplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_kelly
SET_CUTSCENE_ANIM cs_kelly cskelly

CREATE_CUTSCENE_OBJECT SPECIAL03 cs_buddy
SET_CUTSCENE_ANIM cs_buddy printra

CREATE_CUTSCENE_OBJECT SPECIAL04 cs_sonny
SET_CUTSCENE_ANIM cs_sonny printrb

CREATE_CUTSCENE_OBJECT SPECIAL05 cs_sgoona
SET_CUTSCENE_ANIM cs_sgoona printrc

CLEAR_AREA -1059.8411 -278.7214 10.4044 1.0 TRUE
SET_PLAYER_COORDINATES player1 -1059.8411 -278.7214 10.4044
SET_PLAYER_HEADING player1 272.2088

SET_FADING_COLOUR 0 0 1

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 2420
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW CAP_01 10000 1//Ok, what's the emergency?
 
WHILE cs_time < 5636
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW CAP_02 10000 1//WHO?
 
WHILE cs_time < 6065
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW CAP_03 10000 1//Tommy...some mob thugs ...said they'd come to take their cut...
 
WHILE cs_time < 10876
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW CAP_04 10000 1//...said it was a Mr. Forello's money...I feel like crap.
 
WHILE cs_time < 14640
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW CAP_05 10000 1//Forelli? SONNY Forelli?
 
WHILE cs_time < 17053
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW CAP_06 10000 1//Yeah, that's the guy...I think...they were very insistent...
 
WHILE cs_time < 20816
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW CAP_07 10000 1//Don't you worry, pop, I'm not angry with you.
 
WHILE cs_time < 22129
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW CAP_08 10000 1//Get him to the hospital.
 
WHILE cs_time < 24218
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW CAP_09 10000 1//Tommy...rip that guy a new asshole for me...
 
WHILE cs_time < 27085
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW CAP_10 10000 1//I'm gonna rip him two.

WHILE cs_time < 27367//28993
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
SET_FADING_COLOUR 0 0 1
DO_FADE 1500 FADE_OUT

WAIT 1000

CLEAR_PRINTS

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

WHILE NOT HAS_CUTSCENE_FINISHED
	WAIT 0
ENDWHILE

SWITCH_RUBBISH ON
CLEAR_CUTSCENE
SET_CAMERA_BEHIND_PLAYER

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
UNLOAD_SPECIAL_CHARACTER 3
UNLOAD_SPECIAL_CHARACTER 4
UNLOAD_SPECIAL_CHARACTER 5

SET_AREA_VISIBLE VIS_MAIN_MAP
LOAD_SCENE -1059.8411 -278.7214 10.4044
/////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////


LOAD_SPECIAL_CHARACTER 1 MBA
LOAD_SPECIAL_CHARACTER 2 MBB
REQUEST_MODEL M4
REQUEST_MODEL CHROMEGUN
REQUEST_MODEL SANCHEZ

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_MODEL_LOADED M4
OR NOT HAS_MODEL_LOADED CHROMEGUN
OR NOT HAS_MODEL_LOADED SANCHEZ
OR NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
	WAIT 0
ENDWHILE

IF malibu_asset_acquired = 1
	//ADD_BLIP_FOR_COORD 499.7910 -63.8411 10.4539 malibu_blip //MALIBU BANK JOB CLUB	510.4471 -80.3717 9.4731
	ADD_SHORT_RANGE_SPRITE_BLIP_FOR_COORD 499.7910 -63.8411 10.4539 RADAR_SPRITE_MALIBUCLUB malibu_blip
	CHANGE_BLIP_SCALE malibu_blip 2
	CHANGE_BLIP_COLOUR malibu_blip PURPLE
ELSE
	malibu_done	= 2
ENDIF

IF porn_asset_acquired = 1
	//ADD_BLIP_FOR_COORD 8.5461 968.7767 9.8996 porn_blip //PORN STUDIO  16.1665 962.5446 9.9069
	ADD_SHORT_RANGE_SPRITE_BLIP_FOR_COORD 8.5461 968.7767 9.8996 RADAR_SPRITE_FILM porn_blip
	DELETE_OBJECT porn_north_gate_closed
ELSE
	porn_done = 2
ENDIF

IF icecream_asset_acquired = 1
	//ADD_BLIP_FOR_COORD -863.9365 -576.4991 10.0646 icecream_blip //ICECREAM FACTORY	-852.5533 -568.4194 10.0567
	ADD_SHORT_RANGE_SPRITE_BLIP_FOR_COORD -863.9365 -576.4991 10.0646 RADAR_SPRITE_ICE icecream_blip
ELSE
	icecream_done = 2
ENDIF

IF taxifirm_asset_acquired = 1
	//ADD_BLIP_FOR_COORD -997.1398 189.8333 10.3916 taxifirm_blip //TAXI FIRM	-1016.2645 199.9105 10.2062
	ADD_SHORT_RANGE_SPRITE_BLIP_FOR_COORD -997.1398 189.8333 10.3916 RADAR_SPRITE_KCABS taxifirm_blip
ELSE
	taxifirm_done = 2
ENDIF

IF boatyard_asset_acquired = 1
	//ADD_BLIP_FOR_COORD -640.8567 -1491.8431 12.7580 boatyard_blip //BOAT YARD -726.0752 -1494.4872 10.3799
	ADD_SHORT_RANGE_SPRITE_BLIP_FOR_COORD -640.8567 -1491.8431 12.7580 RADAR_SPRITE_BOATYARD boatyard_blip
ELSE
	boatyard_done = 2
ENDIF

IF showroom_asset_acquired = 1
	//ADD_BLIP_FOR_COORD -1014.4678 -833.3465 12.0452 showroom_blip //CAR SHOWROOM -1054.7959 -862.4898 12.1155
	ADD_SHORT_RANGE_SPRITE_BLIP_FOR_COORD -1014.4678 -833.3465 12.0452 RADAR_SPRITE_SUNYARD showroom_blip
ELSE
	showroom_done = 2
ENDIF

IF flag_player_on_mission = 0
	CREATE_PROTECTION_PICKUP x y z porn_revenue porn_revenue taxifirm_cash_pickup
	CREATE_PROTECTION_PICKUP x y z porn_revenue porn_revenue porn_cash_pickup
	CREATE_PROTECTION_PICKUP x y z porn_revenue porn_revenue malibu_cash_pickup
	CREATE_PROTECTION_PICKUP x y z porn_revenue porn_revenue icecream_cash_pickup
	CREATE_PROTECTION_PICKUP x y z porn_revenue porn_revenue boatyard_cash_pickup
	CREATE_PROTECTION_PICKUP x y z porn_revenue porn_revenue showroom_cash_pickup
ENDIF

CREATE_CAR SANCHEZ -866.8224 -448.5860 9.8801 collector1_car
SET_CAR_HEADING collector1_car 198.0000
SET_CAR_ONLY_DAMAGED_BY_PLAYER collector1_car TRUE
SET_CAR_CHANGE_LANE collector1_car FALSE
SET_CAR_FORWARD_SPEED collector1_car 10.0

CREATE_CHAR_INSIDE_CAR collector1_car PEDTYPE_CIVMALE SPECIAL01 collector1


GIVE_WEAPON_TO_CHAR collector1 WEAPONTYPE_M4 9999
CLEAR_CHAR_THREAT_SEARCH collector1
SET_CHAR_THREAT_SEARCH collector1 THREAT_PLAYER1
SET_CHAR_PERSONALITY collector1 PEDSTAT_TOUGH_GUY
SET_CHAR_HEALTH	collector1 250
SET_CHAR_CEASE_ATTACK_TIMER collector1 1150
SET_CHAR_HEED_THREATS collector1 TRUE
SET_CHAR_STAY_IN_SAME_PLACE	collector1 TRUE
SET_CHAR_RUNNING collector1 TRUE

CREATE_CHAR_AS_PASSENGER collector1_car PEDTYPE_CIVMALE SPECIAL02 0 collector1_dude1


GIVE_WEAPON_TO_CHAR collector1_dude1 WEAPONTYPE_SHOTGUN 9999
CLEAR_CHAR_THREAT_SEARCH collector1_dude1
SET_CHAR_THREAT_SEARCH collector1_dude1 THREAT_PLAYER1
SET_CHAR_PERSONALITY collector1_dude1 PEDSTAT_TOUGH_GUY
SET_CHAR_HEALTH	collector1_dude1 250
//SET_CHAR_CEASE_ATTACK_TIMER collector1_dude1 1000
SET_CHAR_HEED_THREATS collector1_dude1 TRUE
SET_CHAR_STAY_IN_SAME_PLACE	collector1_dude1 TRUE
SET_CHAR_RUNNING collector1_dude1 TRUE
SET_CHAR_AS_LEADER collector1_dude1 collector1

GOSUB get_next_place
collector1_goto_x = collector_goto_x
collector1_goto_y = collector_goto_y
collector1_goto_z = collector_goto_z
IF NOT IS_CAR_DEAD collector1_car
	CAR_GOTO_COORDINATES_ACCURATE collector1_car collector1_goto_x collector1_goto_y collector1_goto_z
	SET_CAR_CRUISE_SPEED collector1_car	100.0
	SET_CAR_DRIVING_STYLE collector1_car 2
ENDIF


SET_ENTER_CAR_RANGE_MULTIPLIER 10.0

cap1_mission_loop:

	WAIT 0

	GET_GAME_TIMER game_timer

	IF done_bike_cutscene = 3
		IF NOT GET_FADING_STATUS
			SET_PLAYER_CONTROL player1 ON
			SET_EVERYONE_IGNORE_PLAYER player1 FALSE
			SWITCH_WIDESCREEN OFF
			SET_ALL_CARS_CAN_BE_DAMAGED TRUE
			SET_GENERATE_CARS_AROUND_CAMERA FALSE
			SET_CAMERA_BEHIND_PLAYER
			RESTORE_CAMERA_JUMPCUT
			GET_PLAYER_COORDINATES player1 x y z
			LOAD_SCENE x y z
			SET_FADING_COLOUR 0 0 1
			DO_FADE 1500 FADE_IN
			IF NOT IS_CHAR_DEAD	collector1
				ADD_BLIP_FOR_CHAR collector1 collector1_blip
				CHANGE_BLIP_COLOUR collector1_blip RED
			ENDIF
			SET_PLAYER_MOOD player1 PLAYER_MOOD_ANGRY 60000
			done_bike_cutscene = 4
		ENDIF
	ENDIF

	IF done_bike_cutscene = 2
		IF cutscene_timer < game_timer
			SET_FADING_COLOUR 0 0 1
			DO_FADE 1500 FADE_OUT
			done_bike_cutscene = 3
		ENDIF
	ENDIF

	IF done_bike_cutscene = 1
		IF cutscene_timer < game_timer
			IF NOT IS_CAR_DEAD collector1_car
				POINT_CAMERA_AT_CAR collector1_car CAM_ON_A_STRING JUMP_CUT
				cutscene_timer = game_timer + 2000
			ENDIF
			done_bike_cutscene = 2
		ENDIF
	ENDIF

	IF done_bike_cutscene = 0
		IF cutscene_timer < game_timer
			SET_PLAYER_CONTROL player1 OFF
			SET_EVERYONE_IGNORE_PLAYER player1 TRUE
			SWITCH_WIDESCREEN ON
			SET_ALL_CARS_CAN_BE_DAMAGED FALSE
			SET_GENERATE_CARS_AROUND_CAMERA TRUE
			SET_FIXED_CAMERA_POSITION -856.1546 -497.3885 10.7677 0.0 0.0 0.0//-862.8522 -475.8948 10.5281
			IF NOT IS_CAR_DEAD collector1_car
				POINT_CAMERA_AT_CAR collector1_car FIXED JUMP_CUT
			ENDIF
			IF NOT IS_CHAR_DEAD collector1
				GET_CHAR_COORDINATES collector1 x y z
			ENDIF
			LOAD_SCENE x y z
			cutscene_timer = game_timer + 4000
			SET_FADING_COLOUR 0 0 1
			DO_FADE 1500 FADE_IN
			PRINT_NOW CAP1_B1 20000 1 //"The mafia is taxing your businesses, find them and kill them."
			print_timer = game_timer + 20000
			done_bike_cutscene = 1
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD	collector1
		collector = collector1
		collector_car = collector1_car
		collector_counter = collector1_counter
		collector_goto_x = collector1_goto_x
		collector_goto_y = collector1_goto_y
		collector_goto_z = collector1_goto_z
		collector_in_car = collector1_in_car
		collector_stuck_x = collector1_stuck_x
		collector_stuck_y = collector1_stuck_y
		collector_stuck_timer = collector1_stuck_timer
		collector_car_goto_coords_timer = collector1_car_goto_coords_timer
		collector_dude1 = collector1_dude1
		collector_cash = collector1_cash
		collector_in_car_timer = collector1_in_car_timer
		GOSUB do_collectors_stuff
		collector1 = collector
		collector1_car = collector_car
		collector1_counter = collector_counter
		collector1_goto_x = collector_goto_x
		collector1_goto_y = collector_goto_y
		collector1_goto_z = collector_goto_z
		collector1_in_car = collector_in_car
		collector1_stuck_x = collector_stuck_x
		collector1_stuck_y = collector_stuck_y
		collector1_stuck_timer = collector_stuck_timer
		collector1_car_goto_coords_timer = collector_car_goto_coords_timer
		collector1_dude1 = collector_dude1
		collector1_cash = collector_cash
		collector1_in_car_timer = collector_in_car_timer
	ELSE
		REMOVE_BLIP	collector1_blip
		IF NOT IS_CHAR_DEAD collector1_dude1
			IF DOES_CHAR_EXIST collector1
				GET_DEAD_CHAR_PICKUP_COORDS	collector1 x y z
			ENDIF
			IF LOCATE_CHAR_ANY_MEANS_2D	collector1_dude1 x y 30.0 30.0 0
				collector1 = collector1_dude1
				collector1_dude1 = -1
				collector1_cash = 0
				ADD_BLIP_FOR_CHAR collector1 collector1_blip
				CHANGE_BLIP_COLOUR collector1_blip RED
			//ELSE//PUT MORE GOONS HERE
			ELSE
				MARK_CHAR_AS_NO_LONGER_NEEDED collector1_dude1
				collector1_dude1 = -1
			ENDIF
		//ELSE//PUT MORE GOONS HERE
		ELSE
			IF NOT collector1_goto_x = 999999999.0
				IF collector1_goto_x = -852.5533//ICECREAM
					IF icecream_done = 1
						icecream_done = 0
					ENDIF
					IF icecream_cash_pickup_removed = 0
					AND	icecream_done = 2
						icecream_done = 0
					ENDIF
				ENDIF
				IF collector1_goto_x = -1016.2645//TAXIFIRM
					IF taxifirm_done = 1
						taxifirm_done = 0
					ENDIF
					IF taxifirm_cash_pickup_removed = 0
					AND	taxifirm_done = 2
						taxifirm_done = 0
					ENDIF
				ENDIF
				IF collector1_goto_x = -726.0752//BOATYARD
					IF boatyard_done = 1
						boatyard_done = 0
					ENDIF
					IF boatyard_cash_pickup_removed = 0
					AND	boatyard_done = 2
						boatyard_done = 0
					ENDIF
				ENDIF
				IF collector1_goto_x = -1025.1687//SHOWROOM
					IF showroom_done = 1
						showroom_done = 0
					ENDIF
					IF showroom_cash_pickup_removed = 0
					AND	showroom_done = 2
						showroom_done = 0
					ENDIF
				ENDIF
				IF collector1_goto_x = 506.2871//MALIBU
					IF malibu_done = 1
						malibu_done = 0
					ENDIF
					IF malibu_cash_pickup_removed = 0
					AND	malibu_done = 2
						malibu_done = 0
					ENDIF
				ENDIF
				IF collector1_goto_x = 17.6185//PORN
					IF porn_done = 1
						porn_done = 0
					ENDIF
					IF porn_cash_pickup_removed = 0
					AND	porn_done = 2
						porn_done = 0
					ENDIF
				ENDIF
				collector1_goto_x = 999999999.0
				PRINT_NOW CAP1B10 5000 1 //You've capped the Collectors. More are on their way.
			ENDIF
		ENDIF
	ENDIF
	
	IF collector2_flag = 0
		IF IS_CHAR_DEAD	collector1
			CREATE_CAR SANCHEZ -830.2028 756.1009 9.8816 collector2_car
			SET_CAR_HEADING collector2_car 264.7463 
			SET_CAR_ONLY_DAMAGED_BY_PLAYER collector2_car TRUE
			SET_CAR_CHANGE_LANE collector2_car FALSE
			SET_CAR_FORWARD_SPEED collector2_car 10.0

			CREATE_CHAR_INSIDE_CAR collector2_car PEDTYPE_CIVMALE SPECIAL01 collector2


			GIVE_WEAPON_TO_CHAR collector2 WEAPONTYPE_M4 9999
			CLEAR_CHAR_THREAT_SEARCH collector2
			SET_CHAR_THREAT_SEARCH collector2 THREAT_PLAYER1
			SET_CHAR_PERSONALITY collector2 PEDSTAT_TOUGH_GUY
			SET_CHAR_HEALTH	collector2 250
			SET_CHAR_CEASE_ATTACK_TIMER collector2 1150
			SET_CHAR_HEED_THREATS collector2 TRUE
			SET_CHAR_STAY_IN_SAME_PLACE	collector2 TRUE
			SET_CHAR_RUNNING collector2 TRUE
			ADD_BLIP_FOR_CHAR collector2 collector2_blip
			CHANGE_BLIP_COLOUR collector2_blip RED

			CREATE_CHAR_AS_PASSENGER collector2_car PEDTYPE_CIVMALE SPECIAL02 0 collector2_dude1


			GIVE_WEAPON_TO_CHAR collector2_dude1 WEAPONTYPE_SHOTGUN 9999
			CLEAR_CHAR_THREAT_SEARCH collector2_dude1
			SET_CHAR_THREAT_SEARCH collector2_dude1 THREAT_PLAYER1
			SET_CHAR_PERSONALITY collector2_dude1 PEDSTAT_TOUGH_GUY
			SET_CHAR_HEALTH	collector2_dude1 250
			//SET_CHAR_CEASE_ATTACK_TIMER collector2_dude1 1000
			SET_CHAR_HEED_THREATS collector2_dude1 TRUE
			SET_CHAR_STAY_IN_SAME_PLACE	collector2_dude1 TRUE
			SET_CHAR_RUNNING collector2_dude1 TRUE
			SET_CHAR_AS_LEADER collector2_dude1 collector2

			GOSUB get_next_place
			collector2_goto_x = collector_goto_x
			collector2_goto_y = collector_goto_y
			collector2_goto_z = collector_goto_z
			IF NOT IS_CAR_DEAD collector2_car
				CAR_GOTO_COORDINATES_ACCURATE collector2_car collector2_goto_x collector2_goto_y collector2_goto_z
				SET_CAR_CRUISE_SPEED collector2_car	100.0
				SET_CAR_DRIVING_STYLE collector2_car 2
			ENDIF
			collector2_flag = 1
		ENDIF
	ENDIF
		
	IF IS_CHAR_DEAD	collector1
		IF NOT IS_CHAR_DEAD	collector2
			collector = collector2
			collector_car = collector2_car
			collector_counter = collector2_counter
			collector_goto_x = collector2_goto_x
			collector_goto_y = collector2_goto_y
			collector_goto_z = collector2_goto_z
			collector_in_car = collector2_in_car
			collector_stuck_x = collector2_stuck_x
			collector_stuck_y = collector2_stuck_y
			collector_stuck_timer = collector2_stuck_timer
			collector_car_goto_coords_timer = collector2_car_goto_coords_timer
			collector_dude1 = collector2_dude1
			collector_cash = collector2_cash
			collector_in_car_timer = collector2_in_car_timer
			GOSUB do_collectors_stuff
			collector2 = collector
			collector2_car = collector_car
			collector2_counter = collector_counter
			collector2_goto_x = collector_goto_x
			collector2_goto_y = collector_goto_y
			collector2_goto_z = collector_goto_z
			collector2_in_car = collector_in_car
			collector2_stuck_x = collector_stuck_x
			collector2_stuck_y = collector_stuck_y
			collector2_stuck_timer = collector_stuck_timer
			collector2_car_goto_coords_timer = collector_car_goto_coords_timer
			collector2_dude1 = collector_dude1
			collector2_cash = collector_cash
			collector2_in_car_timer = collector_in_car_timer
		ELSE
			REMOVE_BLIP	collector2_blip
			IF NOT IS_CHAR_DEAD collector2_dude1
				IF DOES_CHAR_EXIST collector2
					GET_DEAD_CHAR_PICKUP_COORDS	collector2 x y z
				ENDIF
				IF LOCATE_CHAR_ANY_MEANS_2D	collector2_dude1 x y 30.0 30.0 0
					collector2 = collector2_dude1
					collector2_dude1 = -1
					collector2_cash = 0
					ADD_BLIP_FOR_CHAR collector2 collector2_blip
					CHANGE_BLIP_COLOUR collector2_blip RED
				//ELSE//PUT MORE GOONS HERE
				ELSE
					MARK_CHAR_AS_NO_LONGER_NEEDED collector2_dude1
					collector2_dude1 = -1
				ENDIF
			//ELSE//PUT MORE GOONS HERE
			ELSE
				IF NOT collector2_goto_x = 999999999.0
					IF collector2_goto_x = -852.5533//ICECREAM
						IF icecream_done = 1
							icecream_done = 0
						ENDIF
						IF icecream_cash_pickup_removed = 0
						AND	icecream_done = 2
							icecream_done = 0
						ENDIF
					ENDIF
					IF collector2_goto_x = -1016.2645//TAXIFIRM
						IF taxifirm_done = 1
							taxifirm_done = 0
						ENDIF
						IF taxifirm_cash_pickup_removed = 0
						AND	taxifirm_done = 2
							taxifirm_done = 0
						ENDIF
					ENDIF
					IF collector2_goto_x = -726.0752//BOATYARD
						IF boatyard_done = 1
							boatyard_done = 0
						ENDIF
						IF boatyard_cash_pickup_removed = 0
						AND	boatyard_done = 2
							boatyard_done = 0
						ENDIF
					ENDIF
					IF collector2_goto_x = -1025.1687//SHOWROOM
						IF showroom_done = 1
							showroom_done = 0
						ENDIF
						IF showroom_cash_pickup_removed = 0
						AND	showroom_done = 2
							showroom_done = 0
						ENDIF
					ENDIF
					IF collector2_goto_x = 506.2871//MALIBU
						IF malibu_done = 1
							malibu_done = 0
						ENDIF
						IF malibu_cash_pickup_removed = 0
						AND	malibu_done = 2
							malibu_done = 0
						ENDIF
					ENDIF
					IF collector2_goto_x = 17.6185//PORN
						IF porn_done = 1
							porn_done = 0
						ENDIF
						IF porn_cash_pickup_removed = 0
						AND	porn_done = 2
							porn_done = 0
						ENDIF
					ENDIF
					collector2_goto_x = 999999999.0
					PRINT_NOW CAP1B10 5000 1 //You've capped the Collectors. More are on their way.
				ENDIF
			ENDIF
		ENDIF
	ENDIF
	
	IF collector3_flag = 0
		IF IS_CHAR_DEAD	collector1
		AND	IS_CHAR_DEAD collector2
			CREATE_CAR SANCHEZ -301.5698 1245.7740 9.8718 collector3_car
			SET_CAR_HEADING collector3_car 181.6262
			SET_CAR_ONLY_DAMAGED_BY_PLAYER collector3_car TRUE
			SET_CAR_CHANGE_LANE collector3_car FALSE
			SET_CAR_FORWARD_SPEED collector3_car 10.0

			CREATE_CHAR_INSIDE_CAR collector3_car PEDTYPE_CIVMALE SPECIAL01 collector3


			GIVE_WEAPON_TO_CHAR collector3 WEAPONTYPE_M4 9999
			CLEAR_CHAR_THREAT_SEARCH collector3
			SET_CHAR_THREAT_SEARCH collector3 THREAT_PLAYER1
			SET_CHAR_PERSONALITY collector3 PEDSTAT_TOUGH_GUY
			SET_CHAR_HEALTH	collector3 250
			SET_CHAR_CEASE_ATTACK_TIMER collector3 1150
			SET_CHAR_HEED_THREATS collector3 TRUE
			SET_CHAR_STAY_IN_SAME_PLACE	collector3 TRUE
			SET_CHAR_RUNNING collector3 TRUE
			ADD_BLIP_FOR_CHAR collector3 collector3_blip
			CHANGE_BLIP_COLOUR collector3_blip RED

			CREATE_CHAR_AS_PASSENGER collector3_car PEDTYPE_CIVMALE SPECIAL02 0 collector3_dude1


			GIVE_WEAPON_TO_CHAR collector3_dude1 WEAPONTYPE_SHOTGUN 9999
			CLEAR_CHAR_THREAT_SEARCH collector3_dude1
			SET_CHAR_THREAT_SEARCH collector3_dude1 THREAT_PLAYER1
			SET_CHAR_PERSONALITY collector3_dude1 PEDSTAT_TOUGH_GUY
			SET_CHAR_HEALTH	collector3_dude1 250
			//SET_CHAR_CEASE_ATTACK_TIMER collector3_dude1 1000
			SET_CHAR_HEED_THREATS collector3_dude1 TRUE
			SET_CHAR_STAY_IN_SAME_PLACE	collector3_dude1 TRUE
			SET_CHAR_RUNNING collector3_dude1 TRUE
			SET_CHAR_AS_LEADER collector3_dude1 collector3

			GOSUB get_next_place
			collector3_goto_x = collector_goto_x
			collector3_goto_y = collector_goto_y
			collector3_goto_z = collector_goto_z
			IF NOT IS_CAR_DEAD collector3_car
				CAR_GOTO_COORDINATES_ACCURATE collector3_car collector3_goto_x collector3_goto_y collector3_goto_z
				SET_CAR_CRUISE_SPEED collector3_car	100.0
				SET_CAR_DRIVING_STYLE collector3_car 2
			ENDIF
			collector3_flag = 1
		ENDIF
	ENDIF
	
	IF IS_CHAR_DEAD	collector1
	AND IS_CHAR_DEAD collector2
		IF NOT IS_CHAR_DEAD	collector3
			collector = collector3
			collector_car = collector3_car
			collector_counter = collector3_counter
			collector_goto_x = collector3_goto_x
			collector_goto_y = collector3_goto_y
			collector_goto_z = collector3_goto_z
			collector_in_car = collector3_in_car
			collector_stuck_x = collector3_stuck_x
			collector_stuck_y = collector3_stuck_y
			collector_stuck_timer = collector3_stuck_timer
			collector_car_goto_coords_timer = collector3_car_goto_coords_timer
			collector_dude1 = collector3_dude1
			collector_cash = collector3_cash
			collector_in_car_timer = collector3_in_car_timer
			GOSUB do_collectors_stuff
			collector3 = collector
			collector3_car = collector_car
			collector3_counter = collector_counter
			collector3_goto_x = collector_goto_x
			collector3_goto_y = collector_goto_y
			collector3_goto_z = collector_goto_z
			collector3_in_car = collector_in_car
			collector3_stuck_x = collector_stuck_x
			collector3_stuck_y = collector_stuck_y
			collector3_stuck_timer = collector_stuck_timer
			collector3_car_goto_coords_timer = collector_car_goto_coords_timer
			collector3_dude1 = collector_dude1
			collector3_cash = collector_cash
			collector3_in_car_timer = collector_in_car_timer
		ELSE
			REMOVE_BLIP	collector3_blip
			IF NOT IS_CHAR_DEAD collector3_dude1
				IF DOES_CHAR_EXIST collector3
					GET_DEAD_CHAR_PICKUP_COORDS	collector3 x y z
				ENDIF
				IF LOCATE_CHAR_ANY_MEANS_2D	collector3_dude1 x y 30.0 30.0 0
					collector3 = collector3_dude1
					collector3_dude1 = -1
					collector3_cash = 0
					ADD_BLIP_FOR_CHAR collector3 collector3_blip
					CHANGE_BLIP_COLOUR collector3_blip RED
				//ELSE//PUT MORE GOONS HERE
				ELSE
					MARK_CHAR_AS_NO_LONGER_NEEDED collector3_dude1
					collector3_dude1 = -1
				ENDIF
			//ELSE//PUT MORE GOONS HERE
			ELSE
				GOTO mission_finale1_passed
			ENDIF
		ENDIF
	ENDIF
	
	IF showroom_done = 2
	AND boatyard_done = 2
	AND icecream_done = 2
	AND taxifirm_done = 2
		first_batch_lost = 1
	ELSE
		first_batch_lost = 0
	ENDIF
	IF malibu_done = 2
	AND porn_done = 2
	AND	collector_counter = 0
		second_batch_lost = 1
	ELSE
		second_batch_lost = 0
	ENDIF
	IF first_batch_lost = 1
	AND	second_batch_lost = 1
		PRINT_NOW CAP1_B8 5000 1 //~r~The collector has taxed all of your businesses.
		print_timer = game_timer + 5000
		GOTO mission_finale1_failed
	ENDIF
	
	IF audio_1_flag > 0
		IF audio_1_flag = 3
			IF HAS_MISSION_AUDIO_FINISHED 1
				CLEAR_THIS_PRINT CAP1_2
				audio_1_flag = 0
				is_audio_in_use = 0
				GOTO cap1_mission_loop
			ENDIF
		ENDIF
		IF audio_1_flag = 2
			IF HAS_MISSION_AUDIO_LOADED 1
				PLAY_MISSION_AUDIO 1
				IF print_timer < game_timer
					//PRINT_NOW CAP1_2 10000 1//You know the rules, Vercetti!
				ENDIF
				audio_1_flag = 3
			ENDIF
		ENDIF
		IF audio_1_flag = 1
			IF is_audio_in_use = 0
				LOAD_MISSION_AUDIO 1 CAP1_2
				audio_1_flag = 2
				is_audio_in_use = 1
			ELSE
				IF game_timer >	audio_1_timeout
					audio_1_flag = 0 
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF audio_2_flag > 0
		IF audio_2_flag = 3
			IF HAS_MISSION_AUDIO_FINISHED 1
				CLEAR_THIS_PRINT CAP1_3
				audio_2_flag = 0
				is_audio_in_use = 0
				GOTO cap1_mission_loop
			ENDIF
		ENDIF
		IF audio_2_flag = 2
			IF HAS_MISSION_AUDIO_LOADED 1
				PLAY_MISSION_AUDIO 1
				IF print_timer < game_timer
					//PRINT_NOW CAP1_3 10000 1//Mr. Forelli sends his regards!
				ENDIF
				audio_2_flag = 3
			ENDIF
		ENDIF
		IF audio_2_flag = 1
			IF is_audio_in_use = 0
				LOAD_MISSION_AUDIO 1 CAP1_3
				audio_2_flag = 2
				is_audio_in_use = 1
			ELSE
				IF game_timer >	audio_2_timeout
					audio_2_flag = 0 
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF audio_3_flag > 0
		IF audio_3_flag = 3
			IF HAS_MISSION_AUDIO_FINISHED 1
				CLEAR_THIS_PRINT CAP1_4
				audio_3_flag = 0
				is_audio_in_use = 0
				GOTO cap1_mission_loop
			ENDIF
		ENDIF
		IF audio_3_flag = 2
			IF HAS_MISSION_AUDIO_LOADED 1
				PLAY_MISSION_AUDIO 1
				IF print_timer < game_timer
					//PRINT_NOW CAP1_4 10000 1//It's the Harwood Butcher!
				ENDIF
				audio_3_flag = 3
			ENDIF
		ENDIF
		IF audio_3_flag = 1
			IF is_audio_in_use = 0
				LOAD_MISSION_AUDIO 1 CAP1_4
				audio_3_flag = 2
				is_audio_in_use = 1
			ELSE
				IF game_timer >	audio_3_timeout
					audio_3_flag = 0 
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF audio_4_flag > 0
		IF audio_4_flag = 3
			IF HAS_MISSION_AUDIO_FINISHED 1
				CLEAR_THIS_PRINT CAP1_5
				audio_4_flag = 0
				is_audio_in_use = 0
				GOTO cap1_mission_loop
			ENDIF
		ENDIF
		IF audio_4_flag = 2
			IF HAS_MISSION_AUDIO_LOADED 1
				PLAY_MISSION_AUDIO 1
				IF print_timer < game_timer
					//PRINT_NOW CAP1_5 10000 1//You tell Sonny - stay away
				ENDIF
				audio_4_flag = 3
			ENDIF
		ENDIF
		IF audio_4_flag = 1
			IF is_audio_in_use = 0
				LOAD_MISSION_AUDIO 1 CAP1_5
				audio_4_flag = 2
				is_audio_in_use = 1
			ELSE
				IF game_timer >	audio_4_timeout
					audio_4_flag = 0 
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF audio_5_flag > 0
		IF audio_5_flag = 3
			IF HAS_MISSION_AUDIO_FINISHED 1
				CLEAR_THIS_PRINT CAP1_6
				audio_5_flag = 0
				is_audio_in_use = 0
				GOTO cap1_mission_loop
			ENDIF
		ENDIF
		IF audio_5_flag = 2
			IF HAS_MISSION_AUDIO_LOADED 1
				PLAY_MISSION_AUDIO 1
				IF print_timer < game_timer
					//PRINT_NOW CAP1_6 10000 1
				ENDIF
				audio_5_flag = 3
			ENDIF
		ENDIF
		IF audio_5_flag = 1
			IF is_audio_in_use = 0
				LOAD_MISSION_AUDIO 1 CAP1_6//Vice City is MINE now, NOT his.
				audio_5_flag = 2
				is_audio_in_use = 1
			ELSE
				IF game_timer >	audio_5_timeout
					audio_5_flag = 0 
				ENDIF
			ENDIF
		ENDIF
		IF audio_5_flag = 0
			audio_5_timeout = game_timer + 6000
			audio_5_flag = 1
		ENDIF
	ENDIF

	IF audio_6_flag > 0
		IF audio_6_flag = 3
			IF HAS_MISSION_AUDIO_FINISHED 1
				CLEAR_THIS_PRINT CAP1_7
				audio_6_flag = 0
				is_audio_in_use = 0
				GOTO cap1_mission_loop
			ENDIF
		ENDIF
		IF audio_6_flag = 2
			IF HAS_MISSION_AUDIO_LOADED 1
				PLAY_MISSION_AUDIO 1
				IF print_timer < game_timer
					//PRINT_NOW CAP1_7 10000 1//You think you can take me down, Vercetti?
				ENDIF
				audio_6_flag = 3
			ENDIF
		ENDIF
		IF audio_6_flag = 1
			IF is_audio_in_use = 0
				LOAD_MISSION_AUDIO 1 CAP1_7
				audio_6_flag = 2
				is_audio_in_use = 1
			ELSE
				IF game_timer >	audio_6_timeout
					audio_6_flag = 0 
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF audio_7_flag > 0
		IF audio_7_flag = 3
			IF HAS_MISSION_AUDIO_FINISHED 1
				CLEAR_THIS_PRINT CAP1_8
				audio_7_flag = 0
				is_audio_in_use = 0
				GOTO cap1_mission_loop
			ENDIF
		ENDIF
		IF audio_7_flag = 2
			IF HAS_MISSION_AUDIO_LOADED 1
				PLAY_MISSION_AUDIO 1
				IF print_timer < game_timer
					//PRINT_NOW CAP1_8 10000 1//We'll keep coming after you until you die, Vercetti
				ENDIF
				audio_7_flag = 3
			ENDIF
		ENDIF
		IF audio_7_flag = 1
			IF is_audio_in_use = 0
				LOAD_MISSION_AUDIO 1 CAP1_8
				audio_7_flag = 2
				is_audio_in_use = 1
			ELSE
				IF game_timer >	audio_7_timeout
					audio_7_flag = 0 
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF audio_8_flag > 0
		IF audio_8_flag = 3
			IF HAS_MISSION_AUDIO_FINISHED 1
				CLEAR_THIS_PRINT CAP1_9
				audio_8_flag = 0
				is_audio_in_use = 0
				GOTO cap1_mission_loop
			ENDIF
		ENDIF
		IF audio_8_flag = 2
			IF HAS_MISSION_AUDIO_LOADED 1
				PLAY_MISSION_AUDIO 1
				IF print_timer < game_timer
					//PRINT_NOW CAP1_9 10000 1//You don't stand a chance, you psychotic prick
				ENDIF
				audio_8_flag = 3
			ENDIF
		ENDIF
		IF audio_8_flag = 1
			IF is_audio_in_use = 0
				LOAD_MISSION_AUDIO 1 CAP1_9
				audio_8_flag = 2
				is_audio_in_use = 1
			ELSE
				IF game_timer >	audio_8_timeout
					audio_8_flag = 0 
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF audio_9_flag > 0
		IF audio_9_flag = 3
			IF HAS_MISSION_AUDIO_FINISHED 1
				CLEAR_THIS_PRINT CAP1_10
				audio_9_flag = 0
				is_audio_in_use = 0
				GOTO cap1_mission_loop
			ENDIF
		ENDIF
		IF audio_9_flag = 2
			IF HAS_MISSION_AUDIO_LOADED 1
				PLAY_MISSION_AUDIO 1
				IF print_timer < game_timer
					//PRINT_NOW CAP1_10 10000 1//I'll murder you Vercetti
				ENDIF
				audio_9_flag = 3
			ENDIF
		ENDIF
		IF audio_9_flag = 1
			IF is_audio_in_use = 0
				LOAD_MISSION_AUDIO 1 CAP1_10
				audio_9_flag = 2
				is_audio_in_use = 1
			ELSE
				IF game_timer >	audio_9_timeout
					audio_9_flag = 0 
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF audio_10_flag > 0
		IF audio_10_flag = 3
			IF HAS_MISSION_AUDIO_FINISHED 1
				CLEAR_THIS_PRINT CAP1_11
				audio_10_flag = 0
				is_audio_in_use = 0
				GOTO cap1_mission_loop
			ENDIF
		ENDIF
		IF audio_10_flag = 2
			IF HAS_MISSION_AUDIO_LOADED 1
				PLAY_MISSION_AUDIO 1
				IF print_timer < game_timer
					//PRINT_NOW CAP1_11 10000 1//You always were a jerk
				ENDIF
				audio_10_flag = 3
			ENDIF
		ENDIF
		IF audio_10_flag = 1
			IF is_audio_in_use = 0
				LOAD_MISSION_AUDIO 1 CAP1_11
				audio_10_flag = 2
				is_audio_in_use = 1
			ELSE
				IF game_timer >	audio_10_timeout
					audio_10_flag = 0 
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF audio_11_flag > 0
		IF audio_11_flag = 3
			IF HAS_MISSION_AUDIO_FINISHED 1
				CLEAR_THIS_PRINT CAP1_12
				audio_11_flag = 0
				is_audio_in_use = 0
				GOTO cap1_mission_loop
			ENDIF
		ENDIF
		IF audio_11_flag = 2
			IF HAS_MISSION_AUDIO_LOADED 1
				PLAY_MISSION_AUDIO 1
				IF print_timer < game_timer
					//PRINT_NOW CAP1_12 10000 1//You're going to die, Vercetti
				ENDIF
				audio_11_flag = 3
			ENDIF
		ENDIF
		IF audio_11_flag = 1
			IF is_audio_in_use = 0
				LOAD_MISSION_AUDIO 1 CAP1_12
				audio_11_flag = 2
				is_audio_in_use = 1
			ELSE
				IF game_timer >	audio_11_timeout
					audio_11_flag = 0 
				ENDIF
			ENDIF
		ENDIF
	ENDIF

GOTO cap1_mission_loop


	
// Mission Finale 1 failed

mission_finale1_failed:
PRINT_BIG M_FAIL 5000 1
RETURN

   

// mission Finale 1 passed

mission_finale1_passed:

flag_finale_mission1_passed = 1
PRINT_WITH_NUMBER_BIG M_PASS 30000 5000 1
ADD_SCORE player1 30000
CLEAR_WANTED_LEVEL player1
PLAY_MISSION_PASSED_TUNE 1
REGISTER_MISSION_PASSED CAP_1
PLAYER_MADE_PROGRESS 1
REMOVE_BLIP counter_contact_blip
ADD_SHORT_RANGE_SPRITE_BLIP_FOR_COORD counterX counterY counterZ the_counter_blip counter_contact_blip
REMOVE_PICKUP printworks_cash_pickup
CREATE_PROTECTION_PICKUP printbuyX printbuyY printbuyZ printworks_revenue printworks_revenue printworks_cash_pickup
//START_NEW_SCRIPT finale_mission2_loop
RETURN
		


// mission cleanup

mission_cleanup_finale1:

IF icecream_cash_pickup_removed = 1
	REMOVE_PICKUP icecream_cash_pickup
	CREATE_PROTECTION_PICKUP icebuyX icebuyY icebuyZ icecream_revenue icecream_revenue icecream_cash_pickup 
ENDIF

IF taxifirm_cash_pickup_removed = 1
	REMOVE_PICKUP taxifirm_cash_pickup
	CREATE_PROTECTION_PICKUP taxicashX taxicashY taxicashZ taxifirm_revenue taxifirm_revenue taxifirm_cash_pickup 
ENDIF

IF boatyard_cash_pickup_removed = 1
	REMOVE_PICKUP boatyard_cash_pickup
	CREATE_PROTECTION_PICKUP boatcashX boatcashY boatcashZ boatyard_revenue boatyard_revenue boatyard_cash_pickup 
ENDIF

IF malibu_cash_pickup_removed = 1
	REMOVE_PICKUP malibu_cash_pickup
	CREATE_PROTECTION_PICKUP bankbuyX bankbuyY bankbuyZ malibu_revenue malibu_revenue malibu_cash_pickup 
ENDIF

IF showroom_cash_pickup_removed = 1
	REMOVE_PICKUP showroom_cash_pickup
	CREATE_PROTECTION_PICKUP carbuyX carbuyY carbuyZ showroom_revenue showroom_revenue showroom_cash_pickup 
ENDIF

IF porn_cash_pickup_removed = 1
	REMOVE_PICKUP porn_cash_pickup
	CREATE_PROTECTION_PICKUP porncashX porncashY porncashZ porn_revenue porn_revenue porn_cash_pickup 
ENDIF

REMOVE_CHAR_ELEGANTLY collector1
REMOVE_CHAR_ELEGANTLY collector1_dude1
REMOVE_CHAR_ELEGANTLY collector2
REMOVE_CHAR_ELEGANTLY collector2_dude1
REMOVE_CHAR_ELEGANTLY collector3
REMOVE_CHAR_ELEGANTLY collector3_dude1

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
MARK_MODEL_AS_NO_LONGER_NEEDED M4
MARK_MODEL_AS_NO_LONGER_NEEDED CHROMEGUN
MARK_MODEL_AS_NO_LONGER_NEEDED SANCHEZ

REMOVE_BLIP collector1_blip
REMOVE_BLIP collector2_blip
REMOVE_BLIP collector3_blip

REMOVE_BLIP icecream_blip
REMOVE_BLIP taxifirm_blip
REMOVE_BLIP boatyard_blip
REMOVE_BLIP showroom_blip
REMOVE_BLIP malibu_blip
REMOVE_BLIP porn_blip

SET_GENERATE_CARS_AROUND_CAMERA FALSE
REMOVE_STUCK_CAR_CHECK collector1_car

GET_GAME_TIMER timer_mobile_start

flag_player_on_mission = 0

MISSION_HAS_FINISHED
RETURN



////////////////////////////////////////////////////////////////////////////
do_collectors_stuff:////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////
	IF IS_CHAR_SITTING_IN_ANY_CAR collector
		STORE_CAR_CHAR_IS_IN_NO_SAVE collector collector_car
		SET_CAR_ONLY_DAMAGED_BY_PLAYER collector_car TRUE
		SET_CAR_CHANGE_LANE collector_car FALSE

		IF showroom_done = 2
		AND boatyard_done = 2
		AND icecream_done = 2
		AND taxifirm_done = 2
			first_batch_done = 1
		ELSE
			first_batch_done = 0
		ENDIF
		IF malibu_done = 2
		AND porn_done = 2
		AND	collector_counter = 0
			second_batch_done = 1
		ELSE
			second_batch_done = 0
		ENDIF
		
		IF NOT IS_CHAR_DEAD	collector_dude1
			IF NOT LOCATE_CHAR_ANY_MEANS_CHAR_2D collector collector_dude1 20.0 20.0 0
				IF IS_CHAR_IN_CHARS_GROUP collector_dude1 collector
					LEAVE_GROUP	collector_dude1
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS collector_dude1 player1
					SET_CHAR_CEASE_ATTACK_TIMER collector_dude1 0
				ENDIF
			ENDIF
		ELSE
			MARK_CHAR_AS_NO_LONGER_NEEDED collector_dude1
		ENDIF
		
		IF collector_counter = 100
			IF first_batch_done = 1
			AND	second_batch_done = 1
				CAR_WANDER_RANDOMLY	collector_car
			ELSE
				CAR_GOTO_COORDINATES_ACCURATE collector_car collector_goto_x collector_goto_y collector_goto_z
				IF collector_goto_x = -852.5533//ICECREAM
					PRINT_NOW CAP1_D3 5000 1 //~g~The Mafia is leaving the Ice Cream Factory!
					print_timer = game_timer + 5000
				ENDIF
				IF collector_goto_x = -1016.2645//TAXIFIRM
					PRINT_NOW CAP1_D5 5000 1 //~g~The Mafia is leaving the Taxi Firm!
					print_timer = game_timer + 5000
				ENDIF
				IF collector_goto_x = -726.0752//BOATYARD
					PRINT_NOW CAP1_D2 5000 1 //~g~The Mafia is leaving the Boatyard!
					print_timer = game_timer + 5000
				ENDIF
				IF collector_goto_x = -1025.1687//SHOWROOM
					PRINT_NOW CAP1_D4 5000 1 //~g~The Mafia is leaving the Car Showroom!
					print_timer = game_timer + 5000
				ENDIF
				IF collector_goto_x = 506.2871//MALIBU
					PRINT_NOW CAP1_D9 5000 1 //~g~The mafia is leaving The Malibu!
					print_timer = game_timer + 5000
				ENDIF
				IF collector_goto_x = 17.6185//PORN
					PRINT_NOW CAP1_D0 5000 1 //~g~The mafia is leaving the film studio!
					print_timer = game_timer + 5000
				ENDIF
				GOSUB get_next_place
				SET_CAR_MISSION collector_car MISSION_GOTOCOORDS
				CAR_GOTO_COORDINATES_ACCURATE collector_car collector_goto_x collector_goto_y collector_goto_z
			ENDIF
			//IF NOT range_int = 5
			//ELSE
			//	CAR_WANDER_RANDOMLY	collector_car
			//ENDIF
			SET_CAR_CRUISE_SPEED collector_car	100.0
			SET_CAR_DRIVING_STYLE collector_car 2
			collector_counter = 0
		ENDIF
		
		IF collector_in_car = 1
			IF first_batch_done = 1
			AND	second_batch_done = 1
				CAR_WANDER_RANDOMLY	collector_car
			ELSE
				CAR_GOTO_COORDINATES_ACCURATE collector_car collector_goto_x collector_goto_y collector_goto_z
			ENDIF
			SET_CAR_CRUISE_SPEED collector_car	100.0
			SET_CAR_DRIVING_STYLE collector_car 2
		ENDIF
		
		collector_in_car = 0
		
		IF LOCATE_CHAR_ANY_MEANS_3D collector collector_goto_x collector_goto_y collector_goto_z 35.0 35.0 35.0 0
			SET_CAR_CRUISE_SPEED collector_car	8.0
			IF collector_counter = 0
				IF LOCATE_CHAR_ANY_MEANS_3D collector collector_goto_x collector_goto_y collector_goto_z 6.0 6.0 6.0 0
					SET_CAR_TEMP_ACTION collector_car TEMPACT_WAIT 400
				ENDIF
				IF LOCATE_STOPPED_CHAR_ANY_MEANS_3D collector collector_goto_x collector_goto_y collector_goto_z 6.0 6.0 6.0 0
					SET_CAR_TEMP_ACTION	collector_car TEMPACT_WAIT 200
					IF icecream_done = 1
						IF collector_goto_x = -852.5533//ICECREAM
							PRINT_NOW CAP1_C3 5000 1 //~g~The Mafia has arrived at the Ice Cream Factory!
							print_timer = game_timer + 5000
							collector_counter = 1
							SET_CHAR_OBJ_LEAVE_ANY_CAR collector
							icecream_done = 2
						ENDIF
					ENDIF

					IF taxifirm_done = 1
						IF collector_goto_x = -1016.2645//TAXIFIRM
							PRINT_NOW CAP1_C5 5000 1 //~g~The Mafia has arrived at the Taxi Firm!
							print_timer = game_timer + 5000
							collector_counter = 2
							SET_CHAR_OBJ_LEAVE_ANY_CAR collector
							taxifirm_done = 2
						ENDIF
					ENDIF

					IF boatyard_done = 1
						IF collector_goto_x = -726.0752//BOATYARD
							PRINT_NOW CAP1_C2 5000 1 //~g~The Mafia has arrived at the Boatyard!
							print_timer = game_timer + 5000
							collector_counter = 3
							SET_CHAR_OBJ_LEAVE_ANY_CAR collector
							boatyard_done = 2
						ENDIF
					ENDIF

					IF showroom_done = 1
						IF collector_goto_x = -1025.1687//SHOWROOM
							PRINT_NOW CAP1_C4 5000 1 //~g~The Mafia has arrived at the Car Showroom!
							print_timer = game_timer + 5000
							collector_counter = 4
							SET_CHAR_OBJ_LEAVE_ANY_CAR collector
							showroom_done = 2
						ENDIF
					ENDIF

					IF malibu_done = 1
						IF collector_goto_x = 506.2871//MALIBU
							PRINT_NOW CAP1_C9 5000 1 //~g~The mafia has arrived at The Malibu!
							print_timer = game_timer + 5000
							collector_counter = 5
							SET_CHAR_OBJ_LEAVE_ANY_CAR collector
							malibu_done = 2
						ENDIF
					ENDIF

					IF porn_done = 1
						IF collector_goto_x = 17.6185//PORN
							PRINT_NOW CAP1_C0 5000 1 //~g~The mafia has arrived at the film studio!
							print_timer = game_timer + 5000
							collector_counter = 6
							SET_CHAR_OBJ_LEAVE_ANY_CAR collector
							porn_done = 2
						ENDIF
					ENDIF
//				ELSE
//					CAR_GOTO_COORDINATES_ACCURATE collector_car collector_goto_x collector_goto_y collector_goto_z
				ENDIF		
			ENDIF		
		ELSE			
			IF collector_counter = 0
				IF LOCATE_CHAR_ANY_MEANS_2D collector collector_stuck_x collector_stuck_y 4.0 4.0 0
					IF collector_stuck_timer < game_timer
						IF NOT IS_CAR_ON_SCREEN collector_car
							GET_CAR_COORDINATES collector_car car_x car_y car_z
							GET_CLOSEST_CAR_NODE car_x car_y car_z car_x car_y car_z
							IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY car_x car_y car_z 4.0 4.0 3.0
								IF NOT IS_POINT_ON_SCREEN car_x car_y car_z 4.0
									SET_CAR_COORDINATES collector_car car_x car_y car_z
									TURN_CAR_TO_FACE_COORD collector_car collector_goto_x collector_goto_y
									SET_CAR_CRUISE_SPEED collector_car 100.0
									SET_CAR_DRIVING_STYLE collector_car 2
									collector_stuck_timer = game_timer + 4000
									IF first_batch_done = 1
									AND	second_batch_done = 1
										CAR_WANDER_RANDOMLY	collector_car
									ELSE
										CAR_GOTO_COORDINATES_ACCURATE collector_car collector_goto_x collector_goto_y collector_goto_z
									ENDIF
								ENDIF
							ENDIF
						ENDIF
					ENDIF
				ELSE
					GET_CAR_COORDINATES	collector_car collector_stuck_x collector_stuck_y Z
					collector_stuck_timer = game_timer + 4000
				ENDIF
				IF game_timer > collector_car_goto_coords_timer
					SET_CAR_CRUISE_SPEED collector_car 100.0
					SET_CAR_DRIVING_STYLE collector_car 2
					IF first_batch_done = 1
					AND	second_batch_done = 1
						CAR_WANDER_RANDOMLY	collector_car
					ELSE
						CAR_GOTO_COORDINATES_ACCURATE collector_car collector_goto_x collector_goto_y collector_goto_z
					ENDIF
					collector_car_goto_coords_timer = game_timer + 2000
				ENDIF
			ENDIF
		ENDIF
	ELSE
		
		IF no_obj_timer < game_timer
			SET_CHAR_OBJ_NO_OBJ	collector
			no_obj_timer = game_timer + 1500
		ENDIF

		IF collector_counter = 0
		OR collector_counter = 100
			IF collector_in_car = 0
				IF LOCATE_CHAR_ANY_MEANS_3D collector collector_goto_x collector_goto_y collector_goto_z 6.0 6.0 6.0 0
				AND	collector_counter = 0
					//SET_CAR_TEMP_ACTION	collector_car TEMPACT_WAIT 200
					IF icecream_done = 1
						IF collector_goto_x = -852.5533//ICECREAM
							PRINT_NOW CAP1_C3 5000 1 //~g~The Mafia has arrived at the Ice Cream Factory!
							print_timer = game_timer + 5000
							collector_counter = 1
							//SET_CHAR_OBJ_LEAVE_ANY_CAR collector
							icecream_done = 2
						ENDIF
					ENDIF

					IF taxifirm_done = 1
						IF collector_goto_x = -1016.2645//TAXIFIRM
							PRINT_NOW CAP1_C5 5000 1 //~g~The Mafia has arrived at the Taxi Firm!
							print_timer = game_timer + 5000
							collector_counter = 2
							//SET_CHAR_OBJ_LEAVE_ANY_CAR collector
							taxifirm_done = 2
						ENDIF
					ENDIF

					IF boatyard_done = 1
						IF collector_goto_x = -726.0752//BOATYARD
							PRINT_NOW CAP1_C2 5000 1 //~g~The Mafia has arrived at the Boatyard!
							print_timer = game_timer + 5000
							collector_counter = 3
							//SET_CHAR_OBJ_LEAVE_ANY_CAR collector
							boatyard_done = 2
						ENDIF
					ENDIF

					IF showroom_done = 1
						IF collector_goto_x = -1025.1687//SHOWROOM
							PRINT_NOW CAP1_C4 5000 1 //~g~The Mafia has arrived at the Car Showroom!
							print_timer = game_timer + 5000
							collector_counter = 4
							//SET_CHAR_OBJ_LEAVE_ANY_CAR collector
							showroom_done = 2
						ENDIF
					ENDIF

					IF malibu_done = 1
						IF collector_goto_x = 506.2871//MALIBU
							PRINT_NOW CAP1_C9 5000 1 //~g~The mafia has arrived at The Malibu!
							print_timer = game_timer + 5000
							collector_counter = 5
							//SET_CHAR_OBJ_LEAVE_ANY_CAR collector
							malibu_done = 2
						ENDIF
					ENDIF

					IF porn_done = 1
						IF collector_goto_x = 17.6185//PORN
							PRINT_NOW CAP1_C0 5000 1 //~g~The mafia has arrived at the film studio!
							print_timer = game_timer + 5000
							collector_counter = 6
							//SET_CHAR_OBJ_LEAVE_ANY_CAR collector
							porn_done = 2
						ENDIF
					ENDIF
				ELSE
					IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 collector 30.0 30.0 0
						IF NOT IS_CAR_DEAD collector_car
							IF NOT IS_CAR_IN_WATER collector_car
								IF LOCATE_CHAR_ON_FOOT_CAR_2D collector collector_car 30.0 30.0 0
									SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER collector collector_car
									collector_in_car_timer = game_timer + 8000
									collector_in_car = 1
								ELSE
									gosub_ped = collector
									GOSUB collector_steal_a_car
								ENDIF
							ELSE
								gosub_ped = collector
								GOSUB collector_steal_a_car
							ENDIF
						ELSE
							gosub_ped = collector
							GOSUB collector_steal_a_car
						ENDIF
					ELSE
						SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS collector player1
					ENDIF
				ENDIF
			ENDIF
			IF collector_in_car = 1
				IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 collector 30.0 30.0 0
					IF NOT IS_CAR_DEAD collector_car
						IF NOT IS_CAR_IN_WATER collector_car
							IF LOCATE_CHAR_ON_FOOT_CAR_2D collector collector_car 30.0 30.0 0
								SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER collector collector_car
								IF game_timer >	collector_in_car_timer
									IF NOT IS_CAR_ON_SCREEN	collector_car
										IF NOT IS_CHAR_ON_SCREEN collector
											SET_CHAR_OBJ_NO_OBJ	collector
											GET_CAR_COORDINATES collector_car x y z
											GET_CAR_HEADING collector_car heading
											DELETE_CAR collector_car
											CREATE_CAR SANCHEZ x y z collector_car
											SET_CAR_HEADING collector_car heading
											SET_CAR_ONLY_DAMAGED_BY_PLAYER collector_car TRUE
											SET_CAR_CHANGE_LANE collector_car FALSE
											WARP_CHAR_INTO_CAR collector collector_car
											IF NOT IS_CHAR_DEAD collector_dude1
												IF IS_CAR_PASSENGER_SEAT_FREE collector_car 0
													CREATE_CHAR_AS_PASSENGER collector_car PEDTYPE_CIVMALE SPECIAL02 0 collector_dude1
                         

													GIVE_WEAPON_TO_CHAR collector_dude1 WEAPONTYPE_SHOTGUN 9999
													CLEAR_CHAR_THREAT_SEARCH collector_dude1
													SET_CHAR_THREAT_SEARCH collector_dude1 THREAT_PLAYER1
													SET_CHAR_PERSONALITY collector_dude1 PEDSTAT_TOUGH_GUY
													SET_CHAR_HEALTH	collector_dude1 250
													//SET_CHAR_CEASE_ATTACK_TIMER collector_dude1 1000
													SET_CHAR_HEED_THREATS collector_dude1 TRUE
													SET_CHAR_STAY_IN_SAME_PLACE	collector_dude1 TRUE
													SET_CHAR_RUNNING collector_dude1 TRUE
													SET_CHAR_AS_LEADER collector_dude1 collector
													//WARP_CHAR_INTO_CAR_AS_PASSENGER	collector_dude1	collector_car 0
												ENDIF
											ENDIF
										ENDIF
									ENDIF
								ENDIF
							ELSE
								gosub_ped = collector
								GOSUB collector_steal_a_car
							ENDIF
						ELSE
							gosub_ped = collector
							GOSUB collector_steal_a_car
						ENDIF
					ELSE
						gosub_ped = collector
						GOSUB collector_steal_a_car
					ENDIF
				ELSE
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS collector player1
				ENDIF
			ENDIF
		ELSE
			IF NOT IS_CAR_DEAD collector_car
				SET_CAR_TEMP_ACTION collector_car TEMPACT_WAIT	17
			ENDIF
			
			//ICECREAM
			IF collector_counter = 1
				SET_CHAR_OBJ_RUN_TO_COORD collector icebuyX icebuyY
				SET_CHAR_USE_PEDNODE_SEEK collector FALSE
				collector_counter = 30
			ENDIF
			IF collector_counter = 30
				IF IS_CHAR_STUCK collector
					IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 collector 120.0 120.0 0
						SET_CHAR_COORDINATES collector icebuyX icebuyY 10.5
					ENDIF
				ENDIF
				IF IS_CHAR_OBJ_NO_OBJ collector
					SET_CHAR_OBJ_RUN_TO_COORD collector icebuyX icebuyY
					SET_CHAR_USE_PEDNODE_SEEK collector FALSE
				ENDIF
				IF LOCATE_CHAR_ON_FOOT_2D collector icebuyX icebuyY 1.0 1.0 0
					PRINT_NOW CAP1_B3 5000 1 //~g~The mafia has taxed the icecream factory!
					print_timer = game_timer + 5000
					REMOVE_BLIP icecream_blip
					collector_cash += icecream_revenue
					SET_CHAR_MONEY collector collector_cash
					icecream_cash_pickup_removed = 1
					REMOVE_PICKUP icecream_cash_pickup
					collector_in_car = 0
					collector_counter = 100
				ENDIF
			ENDIF

			//TAXIFIRM
			IF collector_counter = 2
				SET_CHAR_OBJ_RUN_TO_COORD collector -1009.2858 196.7185
				SET_CHAR_USE_PEDNODE_SEEK collector FALSE
				timer = game_timer + 5000
				collector_counter = 7
			ENDIF
			IF collector_counter = 7
				IF IS_CHAR_STUCK collector
					IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 collector 120.0 120.0 0
						SET_CHAR_COORDINATES collector -1009.2858 196.7185 10.5
					ENDIF
				ENDIF
				IF IS_CHAR_OBJ_NO_OBJ collector
					SET_CHAR_OBJ_RUN_TO_COORD collector -1009.2858 196.7185
					SET_CHAR_USE_PEDNODE_SEEK collector FALSE
				ENDIF
				IF LOCATE_CHAR_ON_FOOT_2D collector -1009.2858 196.7185 1.0 1.0 0
					SET_CHAR_OBJ_RUN_TO_COORD collector taxicashX taxicashY
					SET_CHAR_USE_PEDNODE_SEEK collector FALSE
					collector_counter = 8
				ENDIF
			ENDIF
			IF collector_counter = 8
				IF IS_CHAR_OBJ_NO_OBJ collector
					SET_CHAR_OBJ_RUN_TO_COORD collector taxicashX taxicashY
					SET_CHAR_USE_PEDNODE_SEEK collector FALSE
				ENDIF
				IF LOCATE_CHAR_ON_FOOT_2D collector taxicashX taxicashY 1.0 1.0 0
					PRINT_NOW CAP1_B5 5000 1 //~g~The mafia has taxed the taxi firm!
					print_timer = game_timer + 5000
					REMOVE_BLIP	taxifirm_blip
					collector_cash += taxifirm_revenue
					SET_CHAR_MONEY collector collector_cash
					taxifirm_cash_pickup_removed = 1
					REMOVE_PICKUP taxifirm_cash_pickup
					SET_CHAR_OBJ_RUN_TO_COORD collector -1009.2858 196.7185
					collector_counter = 9
				ENDIF
			ENDIF
			IF collector_counter = 9
				IF IS_CHAR_OBJ_NO_OBJ collector
					SET_CHAR_OBJ_RUN_TO_COORD collector -1009.2858 196.7185
					SET_CHAR_USE_PEDNODE_SEEK collector FALSE
				ENDIF
				IF LOCATE_CHAR_ON_FOOT_2D collector -1009.2858 196.7185 1.0 1.0 0
					collector_in_car = 0
					collector_counter = 100
				ENDIF
			ENDIF

			//BOATYARD
			IF collector_counter = 3
				SET_CHAR_OBJ_RUN_TO_COORD collector -725.3655 -1501.6598
				SET_CHAR_USE_PEDNODE_SEEK collector FALSE
				collector_counter = 10
			ENDIF
			IF collector_counter = 10
				IF IS_CHAR_STUCK collector
					IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 collector 120.0 120.0 0
						SET_CHAR_COORDINATES collector -725.3655 -1501.6598 10.8
					ENDIF
				ENDIF
				IF IS_CHAR_OBJ_NO_OBJ collector
					SET_CHAR_OBJ_RUN_TO_COORD collector -725.3655 -1501.6598
					SET_CHAR_USE_PEDNODE_SEEK collector FALSE
				ENDIF
				IF LOCATE_CHAR_ON_FOOT_2D collector -725.3655 -1501.6598 1.0 1.0 0
					SET_CHAR_OBJ_RUN_TO_COORD collector -681.0613 -1490.4276
					SET_CHAR_USE_PEDNODE_SEEK collector FALSE
					collector_counter = 11
				ENDIF
			ENDIF
			IF collector_counter = 11
				IF IS_CHAR_OBJ_NO_OBJ collector
					SET_CHAR_OBJ_RUN_TO_COORD collector -681.0613 -1490.4276
					SET_CHAR_USE_PEDNODE_SEEK collector FALSE
				ENDIF
				IF LOCATE_CHAR_ON_FOOT_2D collector -681.0613 -1490.4276 1.0 1.0 0
					SET_CHAR_OBJ_RUN_TO_COORD collector -636.2616 -1500.1516
					SET_CHAR_USE_PEDNODE_SEEK collector FALSE
					collector_counter = 12
				ENDIF
			ENDIF
			IF collector_counter = 12
				IF IS_CHAR_OBJ_NO_OBJ collector
					SET_CHAR_OBJ_RUN_TO_COORD collector -636.2616 -1500.1516
					SET_CHAR_USE_PEDNODE_SEEK collector FALSE
				ENDIF
				IF LOCATE_CHAR_ON_FOOT_2D collector -636.2616 -1500.1516 1.0 1.0 0
					SET_CHAR_OBJ_RUN_TO_COORD collector -642.8112 -1496.4293
					SET_CHAR_USE_PEDNODE_SEEK collector FALSE
					collector_counter = 13
				ENDIF
			ENDIF
			IF collector_counter = 13
				IF IS_CHAR_OBJ_NO_OBJ collector
					SET_CHAR_OBJ_RUN_TO_COORD collector -642.8112 -1496.4293
					SET_CHAR_USE_PEDNODE_SEEK collector FALSE
				ENDIF
				IF LOCATE_CHAR_ON_FOOT_2D collector -642.8112 -1496.4293 1.0 1.0 0
					SET_CHAR_OBJ_RUN_TO_COORD collector boatcashX boatcashY
					SET_CHAR_USE_PEDNODE_SEEK collector FALSE
					collector_counter = 14
				ENDIF
			ENDIF
			IF collector_counter = 14
				IF IS_CHAR_OBJ_NO_OBJ collector
					SET_CHAR_OBJ_RUN_TO_COORD collector boatcashX boatcashY
					SET_CHAR_USE_PEDNODE_SEEK collector FALSE
				ENDIF
				IF LOCATE_CHAR_ON_FOOT_2D collector boatcashX boatcashY 1.0 1.0 0
					SET_CHAR_OBJ_RUN_TO_COORD collector -642.8112 -1496.4293
					PRINT_NOW CAP1_B2 5000 1 //~g~The mafia has taxed the boat yard!
					print_timer = game_timer + 5000
					REMOVE_PICKUP boatyard_cash_pickup
					boatyard_cash_pickup_removed = 1
					collector_cash += boatyard_revenue
					SET_CHAR_MONEY collector collector_cash
					REMOVE_BLIP boatyard_blip
					collector_counter = 15
				ENDIF
			ENDIF
			IF collector_counter = 15
				IF IS_CHAR_OBJ_NO_OBJ collector
					SET_CHAR_OBJ_RUN_TO_COORD collector -642.8112 -1496.4293
					SET_CHAR_USE_PEDNODE_SEEK collector FALSE
				ENDIF
				IF LOCATE_CHAR_ON_FOOT_2D collector -642.8112 -1496.4293 1.0 1.0 0
					SET_CHAR_OBJ_RUN_TO_COORD collector -636.2616 -1500.1516
					SET_CHAR_USE_PEDNODE_SEEK collector FALSE
					collector_counter = 16
				ENDIF
			ENDIF
			IF collector_counter = 16
				IF IS_CHAR_OBJ_NO_OBJ collector
					SET_CHAR_OBJ_RUN_TO_COORD collector -636.2616 -1500.1516
					SET_CHAR_USE_PEDNODE_SEEK collector FALSE
				ENDIF
				IF LOCATE_CHAR_ON_FOOT_2D collector -636.2616 -1500.1516 1.0 1.0 0
					SET_CHAR_OBJ_RUN_TO_COORD collector -681.0613 -1490.4276
					SET_CHAR_USE_PEDNODE_SEEK collector FALSE
					collector_counter = 17
				ENDIF
			ENDIF
			IF collector_counter = 17
				IF IS_CHAR_OBJ_NO_OBJ collector
					SET_CHAR_OBJ_RUN_TO_COORD collector -681.0613 -1490.4276
					SET_CHAR_USE_PEDNODE_SEEK collector FALSE
				ENDIF
				IF LOCATE_CHAR_ON_FOOT_2D collector -681.0613 -1490.4276 1.0 1.0 0
					SET_CHAR_OBJ_RUN_TO_COORD collector -725.3655 -1501.6598
					SET_CHAR_USE_PEDNODE_SEEK collector FALSE
					collector_counter = 18
				ENDIF
			ENDIF
			IF collector_counter = 18
				IF IS_CHAR_OBJ_NO_OBJ collector
					SET_CHAR_OBJ_RUN_TO_COORD collector -725.3655 -1501.6598
					SET_CHAR_USE_PEDNODE_SEEK collector FALSE
				ENDIF
				IF LOCATE_CHAR_ON_FOOT_2D collector -725.3655 -1501.6598 1.0 1.0 0
					collector_in_car = 0
					collector_counter = 100
				ENDIF
			ENDIF

			//SHOWROOM
			IF collector_counter = 4
				SET_CHAR_OBJ_RUN_TO_COORD collector -1023.7896 -901.9847
				SET_CHAR_USE_PEDNODE_SEEK collector FALSE
				collector_counter = 40
			ENDIF
			IF collector_counter = 40
				IF IS_CHAR_STUCK collector
					IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 collector 120.0 120.0 0
						SET_CHAR_COORDINATES collector -1023.7896 -901.9847 13.8
					ENDIF
				ENDIF
				IF IS_CHAR_OBJ_NO_OBJ collector
					SET_CHAR_OBJ_RUN_TO_COORD collector -1023.7896 -901.9847
					SET_CHAR_USE_PEDNODE_SEEK collector FALSE
				ENDIF
				IF LOCATE_CHAR_ON_FOOT_2D collector -1023.7896 -901.9847 1.0 1.0 0
					SET_CHAR_OBJ_RUN_TO_COORD collector carbuyX carbuyY
					SET_CHAR_USE_PEDNODE_SEEK collector FALSE
					collector_counter = 41
				ENDIF
			ENDIF
			//-1023.7896 -901.9847
			IF collector_counter = 41
				IF IS_CHAR_OBJ_NO_OBJ collector
					SET_CHAR_OBJ_RUN_TO_COORD collector carbuyX carbuyY
					SET_CHAR_USE_PEDNODE_SEEK collector FALSE
				ENDIF
				IF LOCATE_CHAR_ON_FOOT_2D collector carbuyX carbuyY 1.0 1.0 0
					SET_CHAR_OBJ_RUN_TO_COORD collector -1023.7896 -901.9847
					PRINT_NOW CAP1_B4 5000 1 //~g~The mafia has taxed the car showroom!
					print_timer = game_timer + 5000
					REMOVE_PICKUP showroom_cash_pickup
					showroom_cash_pickup_removed = 1
					collector_cash += showroom_revenue
					SET_CHAR_MONEY collector collector_cash
					REMOVE_BLIP	showroom_blip
					collector_in_car = 0
					collector_counter = 42
				ENDIF
			ENDIF
			IF collector_counter = 42
				IF IS_CHAR_OBJ_NO_OBJ collector
					SET_CHAR_OBJ_RUN_TO_COORD collector -1023.7896 -901.9847
					SET_CHAR_USE_PEDNODE_SEEK collector FALSE
				ENDIF
				IF LOCATE_CHAR_ON_FOOT_2D collector -1023.7896 -901.9847 1.0 1.0 0
					collector_in_car = 0
					collector_counter = 100
				ENDIF
			ENDIF
			
			//MALIBU
			IF collector_counter = 5
				SET_CHAR_OBJ_RUN_TO_COORD collector 501.5787 -81.7690
				SET_CHAR_USE_PEDNODE_SEEK collector FALSE
				timer = game_timer + 5000
				collector_counter = 20
			ENDIF
			IF collector_counter = 20
				IF IS_CHAR_STUCK collector
					IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 collector 120.0 120.0 0
						SET_CHAR_COORDINATES collector 501.5787 -81.7690 9.5
					ENDIF
				ENDIF
				IF IS_CHAR_OBJ_NO_OBJ collector
					SET_CHAR_OBJ_RUN_TO_COORD collector 501.5787 -81.7690
					SET_CHAR_USE_PEDNODE_SEEK collector FALSE
				ENDIF
				IF LOCATE_CHAR_ON_FOOT_2D collector 501.5787 -81.7690 1.0 1.0 0
					SET_CHAR_OBJ_RUN_TO_COORD collector 491.7617 -78.5777
					SET_CHAR_USE_PEDNODE_SEEK collector FALSE
					collector_counter = 21
				ENDIF
			ENDIF
			IF collector_counter = 21
				IF IS_CHAR_OBJ_NO_OBJ collector
					SET_CHAR_OBJ_RUN_TO_COORD collector 491.7617 -78.5777
					SET_CHAR_USE_PEDNODE_SEEK collector FALSE
				ENDIF
				IF LOCATE_CHAR_ON_FOOT_2D collector 491.7617 -78.5777 1.0 1.0 0
					SET_CHAR_OBJ_RUN_TO_COORD collector bankbuyX bankbuyY
					SET_CHAR_USE_PEDNODE_SEEK collector FALSE
					collector_counter = 23
				ENDIF
			ENDIF
			IF collector_counter = 23
				IF IS_CHAR_OBJ_NO_OBJ collector
					SET_CHAR_OBJ_RUN_TO_COORD collector bankbuyX bankbuyY
					SET_CHAR_USE_PEDNODE_SEEK collector FALSE
				ENDIF
				IF LOCATE_CHAR_ON_FOOT_2D collector bankbuyX bankbuyY 1.0 1.0 0
					PRINT_NOW CAP1_B9 5000 1 //~g~The mafia has taxed The Malibu!
					print_timer = game_timer + 5000
					REMOVE_BLIP	malibu_blip
					REMOVE_PICKUP malibu_cash_pickup
					collector_cash += malibu_revenue
					SET_CHAR_MONEY collector collector_cash
					malibu_cash_pickup_removed = 1
					SET_CHAR_OBJ_RUN_TO_COORD collector 491.7617 -78.5777
					SET_CHAR_USE_PEDNODE_SEEK collector FALSE
					collector_counter = 25
				ENDIF
			ENDIF
			IF collector_counter = 25
				IF IS_CHAR_OBJ_NO_OBJ collector
					SET_CHAR_OBJ_RUN_TO_COORD collector 491.7617 -78.5777
					SET_CHAR_USE_PEDNODE_SEEK collector FALSE
				ENDIF
				IF LOCATE_CHAR_ON_FOOT_2D collector 491.7617 -78.5777 1.0 1.0 0
					SET_CHAR_OBJ_RUN_TO_COORD collector 501.5787 -81.7690
					SET_CHAR_USE_PEDNODE_SEEK collector FALSE
					collector_counter = 26
				ENDIF
			ENDIF
			IF collector_counter = 26
				IF IS_CHAR_OBJ_NO_OBJ collector
					SET_CHAR_OBJ_RUN_TO_COORD collector 501.5787 -81.7690
					SET_CHAR_USE_PEDNODE_SEEK collector FALSE
				ENDIF
				IF LOCATE_CHAR_ON_FOOT_2D collector 501.5787 -81.7690 1.0 1.0 0
					collector_in_car = 0
					collector_counter = 100
				ENDIF
			ENDIF

			//PORN
			IF collector_counter = 6
				SET_CHAR_OBJ_RUN_TO_COORD collector 12.2850 963.0108
				SET_CHAR_USE_PEDNODE_SEEK collector FALSE
				timer = game_timer + 5000
				collector_counter = 27
			ENDIF
			IF collector_counter = 27
				IF IS_CHAR_STUCK collector
					IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 collector 120.0 120.0 0
						SET_CHAR_COORDINATES collector 12.2850 963.0108 10.5
					ENDIF
				ENDIF
				IF IS_CHAR_OBJ_NO_OBJ collector
					SET_CHAR_OBJ_RUN_TO_COORD collector 12.2850 963.0108
					SET_CHAR_USE_PEDNODE_SEEK collector FALSE
				ENDIF
				IF LOCATE_CHAR_ON_FOOT_2D collector 12.2850 963.0108 1.0 1.0 0
					SET_CHAR_OBJ_RUN_TO_COORD collector porncashX porncashY
					SET_CHAR_USE_PEDNODE_SEEK collector FALSE
					collector_counter = 28
				ENDIF
			ENDIF
			IF collector_counter = 28
				IF IS_CHAR_OBJ_NO_OBJ collector
					SET_CHAR_OBJ_RUN_TO_COORD collector porncashX porncashY
					SET_CHAR_USE_PEDNODE_SEEK collector FALSE
				ENDIF
				IF LOCATE_CHAR_ON_FOOT_2D collector porncashX porncashY 1.0 1.0 0
					PRINT_NOW CAP1_B0 5000 1 //~g~The mafia has taxed the film studio!
					print_timer = game_timer + 5000
					collector_cash += porn_revenue
					SET_CHAR_MONEY collector collector_cash
					REMOVE_BLIP	porn_blip
					REMOVE_PICKUP porn_cash_pickup
					porn_cash_pickup_removed = 1
					SET_CHAR_OBJ_RUN_TO_COORD collector 12.2850 963.0108
					SET_CHAR_USE_PEDNODE_SEEK collector FALSE
					collector_counter = 29
				ENDIF
			ENDIF
			IF collector_counter = 29
				IF IS_CHAR_OBJ_NO_OBJ collector
					SET_CHAR_OBJ_RUN_TO_COORD collector 12.2850 963.0108
					SET_CHAR_USE_PEDNODE_SEEK collector FALSE
				ENDIF
				IF LOCATE_CHAR_ON_FOOT_2D collector 12.2850 963.0108 1.0 1.0 0
					collector_in_car = 0
					collector_counter = 100
				ENDIF
			ENDIF
		ENDIF
	ENDIF
		
	IF LOCATE_PLAYER_ON_FOOT_CHAR_2D player1 collector	40.0 40.0 0
		IF IS_PLAYER_SHOOTING player1
			IF player_audio_timer < game_timer
				IF player_audio_flag = 1
					IF audio_5_flag = 0
						audio_5_flag = 1
						audio_5_timeout = game_timer + 6000
					ENDIF
					player_audio_flag ++
					player_audio_timer = game_timer + 3000
				ENDIF
				IF player_audio_flag = 0
					IF audio_4_flag = 0
						audio_4_flag = 1
						audio_4_timeout = game_timer + 6000
					ENDIF
					player_audio_flag ++
					player_audio_timer = game_timer + 3000
				ENDIF
			ENDIF
		ENDIF
		IF IS_CHAR_SHOOTING	collector
			IF collector_audio_timer < game_timer
				IF collector_audio_flag = 8
					IF audio_10_flag = 0
						audio_10_flag = 1
						audio_10_timeout = game_timer + 6000
					ENDIF
					collector_audio_flag ++
					collector_audio_timer = game_timer + 3000
				ENDIF
				IF collector_audio_flag = 7
					IF audio_9_flag = 0
						audio_9_flag = 1
						audio_9_timeout = game_timer + 6000
					ENDIF
					collector_audio_flag ++
					collector_audio_timer = game_timer + 3000
				ENDIF
				IF collector_audio_flag = 6
					IF audio_6_flag = 0
						audio_6_flag = 1
						audio_6_timeout = game_timer + 6000
					ENDIF
					collector_audio_flag ++
					collector_audio_timer = game_timer + 3000
				ENDIF
				IF collector_audio_flag = 5
					IF audio_8_flag = 0
						audio_8_flag = 1
						audio_8_timeout = game_timer + 6000
					ENDIF
					collector_audio_flag ++
					collector_audio_timer = game_timer + 3000
				ENDIF
				IF collector_audio_flag = 4
					IF audio_7_flag = 0
						audio_7_flag = 1
						audio_7_timeout = game_timer + 6000
					ENDIF
					collector_audio_flag ++
					collector_audio_timer = game_timer + 3000
				ENDIF
				IF collector_audio_flag = 3
					IF audio_2_flag = 0
						audio_2_flag = 1
						audio_2_timeout = game_timer + 6000
					ENDIF
					collector_audio_flag ++
					collector_audio_timer = game_timer + 3000
				ENDIF
				IF collector_audio_flag = 2
					IF audio_1_flag = 0
						audio_1_flag = 1
						audio_1_timeout = game_timer + 6000
					ENDIF
					collector_audio_flag ++
					collector_audio_timer = game_timer + 3000
				ENDIF
				IF collector_audio_flag = 1
					IF audio_11_flag = 0
						audio_11_flag = 1
						audio_11_timeout = game_timer + 6000
					ENDIF
					collector_audio_flag ++
					collector_audio_timer = game_timer + 3000
				ENDIF
				IF collector_audio_flag = 0
					IF audio_3_flag = 0
						audio_3_flag = 1
						audio_3_timeout = game_timer + 6000
					ENDIF
					collector_audio_flag ++
					collector_audio_timer = game_timer + 3000
				ENDIF
			ENDIF
		ENDIF
	ENDIF
////////////////////////////////////////////////////////////////////////////
RETURN//////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////


////////////////////////////////////////////////////////////////////////////
get_next_place://///////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////

IF boatyard_done = 0
	collector_goto_x = -726.0752//BOATYARD
	collector_goto_y = -1494.4872
	collector_goto_z = 10.3799
	boatyard_done = 1
	RETURN
ENDIF
IF showroom_done = 0
	collector_goto_x = -1025.1687//SHOWROOM
	collector_goto_y = -904.9712
	collector_goto_z = 13.2096
	showroom_done = 1
	RETURN
ENDIF
IF malibu_done = 0
	collector_goto_x = 506.2871//MALIBU
	collector_goto_y = -82.8296
	collector_goto_z = 9.2532
	malibu_done = 1
	RETURN
ENDIF
IF icecream_done = 0
	collector_goto_x = -852.5533//ICECREAM
	collector_goto_y = -568.4194
	collector_goto_z = 10.0567
	icecream_done = 1
	RETURN
ENDIF
IF taxifirm_done = 0
	collector_goto_x = -1016.2645//TAXIFIRM
	collector_goto_y = 199.9105
	collector_goto_z = 10.2062
	taxifirm_done = 1
	RETURN
ENDIF
IF porn_done = 0
	collector_goto_x = 17.6185//PORN
	collector_goto_y = 962.1060 
	collector_goto_z = 9.727
	porn_done = 1
	RETURN
ENDIF
range_int = 5

////////////////////////////////////////////////////////////////////////////
RETURN//////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////



////////////////////////////////////////////////////////////////////////////
collector_steal_a_car: /////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////

IF NOT IS_CHAR_DEAD	gosub_ped
	IF heading = 919.9
		CREATE_CAR SANCHEZ	coord_1_x coord_1_y coord_1_z car
	ENDIF

	GET_CHAR_COORDINATES gosub_ped coord_1_x coord_1_y coord_1_z

	IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 gosub_ped 30.0 30.0 0
		coord_2_x = coord_1_x + 40.0
		coord_2_y = coord_1_y + 40.0
		coord_1_x = coord_1_x - 40.0
		coord_1_y = coord_1_y - 40.0
		MARK_CAR_AS_NO_LONGER_NEEDED car
		car = -1
		GET_RANDOM_CAR_OF_TYPE_IN_AREA coord_1_x coord_1_y coord_2_x coord_2_y -1 car
		IF car = -1
		OR collector1_car = car
			SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS gosub_ped player1
		ELSE
			IF IS_CAR_HEALTH_GREATER car 400
				GET_NUMBER_OF_FOLLOWERS gosub_ped num_of_followers
				GET_MAXIMUM_NUMBER_OF_PASSENGERS car max_passengers
				LOCK_CAR_DOORS car CARLOCK_UNLOCKED
				SET_CAR_CRUISE_SPEED car 0.0
				SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER gosub_ped car
			ELSE
				SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS gosub_ped player1
				MARK_CAR_AS_NO_LONGER_NEEDED car
				car = -1
			ENDIF
		ENDIF
	ELSE
		GET_CLOSEST_CAR_NODE_WITH_HEADING coord_1_x coord_1_y coord_1_z coord_1_x coord_1_y coord_1_z heading
		IF NOT IS_POINT_ON_SCREEN coord_1_x coord_1_y coord_1_z 3.0
			IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY coord_1_x coord_1_y coord_1_z 3.0 3.0 2.0
				IF HAS_MODEL_LOADED	SANCHEZ
					MARK_CAR_AS_NO_LONGER_NEEDED car
					CREATE_CAR SANCHEZ	coord_1_x coord_1_y coord_1_z car
					SET_CAR_HEADING	car heading
					SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER gosub_ped car
				ENDIF
			ELSE
				IF LOCATE_CHAR_ON_FOOT_3D gosub_ped coord_1_x coord_1_y coord_1_z 3.0 3.0 2.0 0
					GET_CLOSEST_CHAR_NODE coord_1_x coord_1_y coord_1_z coord_1_x coord_1_y coord_1_z
					SET_CHAR_OBJ_RUN_TO_COORD gosub_ped	coord_1_x coord_1_y
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF

////////////////////////////////////////////////////////////////////////////
RETURN//////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////


}