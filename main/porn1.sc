MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************Porn 1******************************************
// *****************************************Ho Today, Porn Tomorrow*************************
// *****************************************************************************************
// *****************************************************************************************
SCRIPT_NAME porno1
// Mission start stuff
GOSUB mission_start_porn1
IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_failed_porn1
ENDIF
GOSUB mission_cleanup_porn1
MISSION_END
{ 
// Variables for mission
//people, cars and objects
VAR_INT pap_car
VAR_INT candy_sexxx
VAR_INT pap_man
VAR_INT pap_guard1
VAR_INT pap_guard2
VAR_INT pap_guard3
VAR_INT mercedes 
VAR_INT player_car_porn1  
VAR_INT candy_stretch_limo
VAR_INT candy_limo_driver 
VAR_INT tits_car

//blips
//VAR_INT pap_car_blip
VAR_INT candy_sexxx_blip
VAR_INT pap_man_blip
VAR_INT mercedes_blip
VAR_INT pron_studio

//flags
VAR_INT porn1_goals
VAR_INT pap_guards_count
VAR_INT pap_blip_flag
VAR_INT pap_car_health
VAR_INT random_car_wander 
VAR_INT timera_reset
VAR_INT candy_sexxx_waitstate
VAR_INT flag_candy_sexxx_in_group
VAR_INT flag_mercedes_in_group 
VAR_INT candy_out_limo
VAR_INT candy_tits1
VAR_INT candy_tits2
VAR_INT tits_car_health
VAR_FLOAT tits_car_speed

//coordinates 
VAR_FLOAT papcar_coordx 
VAR_FLOAT papcar_coordy 
VAR_FLOAT papcar_coord2x 
VAR_FLOAT papcar_coord2y
VAR_FLOAT papcar_coordz

//cutscene stuff 
VAR_INT cs_juggz

// ****************************************Mission Start************************************
mission_start_porn1:
CLEAR_THIS_PRINT M_FAIL
flag_player_on_mission = 1
REGISTER_MISSION_GIVEN
WAIT 0
LOAD_MISSION_TEXT PORN1
SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION 21.489 966.28 9.5 172.7
// *****************************************Set Flags/variables************************************

pap_guards_count = 0
pap_blip_flag = 0
porn1_goals = 0
papcar_coordx = 0.0 

pap_car_health = 0 
random_car_wander = 0
timera_reset = 0 

candy_sexxx_waitstate = 0
flag_candy_sexxx_in_group = 0
flag_mercedes_in_group = 0
candy_out_limo = 0

papcar_coordy = 0.0 
papcar_coord2x = 0.0 
papcar_coord2y = 0.0
papcar_coordz = 0.0

candy_tits1 = 0
candy_tits2 = 0
tits_car_health = 0
tits_car_speed = 0.0

// ****************************************START OF CUTSCENE********************************
LOAD_MISSION_AUDIO 1 MONO_3

LOAD_SPECIAL_CHARACTER 1 CSplay
LOAD_SPECIAL_CHARACTER 2 CSdirec
LOAD_SPECIAL_CHARACTER 3 CSjuggz
LOAD_SPECIAL_CHARACTER 4 cmraman
LOAD_SPECIAL_CHARACTER 5 mporna

LOAD_SPECIAL_MODEL CUTOBJ01 cs_cam
LOAD_SPECIAL_MODEL CUTOBJ02 drchair

LOAD_SCENE -86.0 929.0 9.764

LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_SPECIAL_CHARACTER_LOADED 3
OR NOT HAS_SPECIAL_CHARACTER_LOADED 4
OR NOT HAS_SPECIAL_CHARACTER_LOADED 5
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED CUTOBJ01
OR NOT HAS_MODEL_LOADED CUTOBJ02
	WAIT 0
ENDWHILE

LOAD_CUTSCENE porn_1
SET_CUTSCENE_OFFSET -69.128 920.965 9.764
SET_NEAR_CLIP 0.1
				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player CSplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_direc
SET_CUTSCENE_ANIM cs_direc CSdirec

CREATE_CUTSCENE_OBJECT SPECIAL03 cs_juggz
SET_CUTSCENE_ANIM cs_juggz CSjuggz

CREATE_CUTSCENE_OBJECT SPECIAL04 cs_cmraman
SET_CUTSCENE_ANIM cs_cmraman cmraman

CREATE_CUTSCENE_OBJECT SPECIAL05 cs_mporna
SET_CUTSCENE_ANIM cs_mporna mporna

CREATE_CUTSCENE_OBJECT CUTOBJ01 cs_camera
SET_CUTSCENE_ANIM cs_camera cs_cam 

CREATE_CUTSCENE_OBJECT CUTOBJ02 cs_drchair
SET_CUTSCENE_ANIM cs_drchair drchair 

CLEAR_AREA -66.0 933.04 10.2 1.0 TRUE
SET_PLAYER_COORDINATES player1 -66.0 933.04 10.2
SET_PLAYER_HEADING player1 275.6

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 2533  //FIRST CUTSCENE TIME GOES HERE
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW POR1_A 10000 1 // Action

WHILE cs_time < 3343
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR1_B 10000 1 // Who!, Now that's big  

WHILE cs_time < 6008
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR1_C 10000 1 // 12 inches, that is regulation baby.

WHILE cs_time < 11226
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR1_D 10000 1 // CUT!! Who IS this idiot? You! YOU! Why are you in my space? WHY?

WHILE cs_time < 16462
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR1_E 10000 1 // What is all this crap? 

WHILE cs_time < 18076
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR1_F 10000 1 // Aliens? Fishing poles? 

WHILE cs_time < 20247
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR1_G 10000 1 // Who has ever seen a shark that big?

WHILE cs_time < 22282
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR1_H 10000 1 // All this stuff's gotta go.

WHILE cs_time < 24320
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR1_I 10000 1 //Why'd you get in this business, you prick?

WHILE cs_time < 26352
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR1_J 10000 1 //Huh?

WHILE cs_time < 27126
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR1_K 10000 1 //For the pussy, that's why! What is this??

WHILE cs_time < 30127
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR1_L 10000 1 //This? This is my art -SECURITY!

WHILE cs_time < 34028
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR1_M 10000 1 //Look, you pompous asshole, I own you now. I own all of this.

WHILE cs_time < 38273
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR1_N 10000 1 //We're going to turn this place around...

WHILE cs_time < 40013
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR1_O 10000 1 //I'm going to make you rich

WHILE cs_time < 42086
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR1_P 10000 1 //Uh..You're-you-you're Tommy Vercetti? But they said that you were-

WHILE cs_time < 46091
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR1_Q 10000 1 //That's right.

WHILE cs_time < 47169
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR1_R 10000 1 //We're going to make some changes around here and start making some real money.

WHILE cs_time < 50143
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR1_S 10000 1 //Actually, have you ever thought about...

WHILE cs_time < 52720
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR1_T 10000 1 //But first we're going to need some good-looking broads

WHILE cs_time < 54090
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR1_U 10000 1 //Yeh, girls are fine but you... wow!

/*
WHILE cs_time < 55090
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS
*/
WHILE cs_time < 56976
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

DO_FADE 1500 FADE_OUT

CLEAR_PRINTS

WAIT 1000

IF NOT WAS_CUTSCENE_SKIPPED
	IF HAS_MISSION_AUDIO_LOADED	1
		PLAY_MISSION_AUDIO 1
	ENDIF
ENDIF

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

SWITCH_RUBBISH ON
CLEAR_CUTSCENE

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
UNLOAD_SPECIAL_CHARACTER 3
UNLOAD_SPECIAL_CHARACTER 4
UNLOAD_SPECIAL_CHARACTER 5
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ01
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ02
SET_CAR_DENSITY_MULTIPLIER 1.0
SET_PED_DENSITY_MULTIPLIER 1.0

/*
IF NOT WAS_CUTSCENE_SKIPPED
	WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
		WAIT 0
	ENDWHILE
ENDIF
*/
// ******************************************END OF CUTSCENE********************************
SET_FADING_COLOUR 0 0 0
WAIT 500
LOAD_SCENE -67.000 939.297 10.940
SET_CAMERA_BEHIND_PLAYER
//------------------REQUEST_MODELS ------------------------------
SET_PLAYER_MOOD player1 PLAYER_MOOD_CALM 60000
										 
REQUEST_MODEL WMYPI
REQUEST_MODEL BMYCR
REQUEST_MODEL HMYRI
REQUEST_MODEL sentinel
REQUEST_MODEL bat
REQUEST_MODEL tec9
REQUEST_MODEL stretch

WHILE NOT HAS_MODEL_LOADED WMYPI 
OR NOT HAS_MODEL_LOADED BMYCR
OR NOT HAS_MODEL_LOADED HMYRI
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED sentinel
OR NOT HAS_MODEL_LOADED bat
OR NOT HAS_MODEL_LOADED tec9
OR NOT HAS_MODEL_LOADED stretch
	WAIT 0
ENDWHILE

LOAD_SPECIAL_CHARACTER 1 IGCandy
LOAD_SPECIAL_CHARACTER 2 IGMerc

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2 
	WAIT 0
ENDWHILE
LOAD_ALL_MODELS_NOW

ADD_BLIP_FOR_COORD -448.3 1324.6 10.7 candy_sexxx_blip  

DO_FADE 1500 FADE_IN

PRINT_NOW ( POR1_01 ) 5000 1 //Candy Suxxx would be perfect for a starring role!
PRINT ( POR1_23 ) 5000 1 //Candy will be taking care of business ~h~Downtown~g~.

SET_ENTER_CAR_RANGE_MULTIPLIER 3.0

WHILE NOT LOCATE_PLAYER_ON_FOOT_3D player1 -448.3 1324.6 10.7 1.0 1.0 2.0 TRUE
	WAIT 0
	IF LOCATE_PLAYER_IN_CAR_3D player1 -448.3 1324.6 10.7 20.0 20.0 20.0 FALSE
		STORE_CAR_PLAYER_IS_IN player1 player_car_porn1 
	ENDIF
ENDWHILE

LOAD_MISSION_AUDIO 1 PORN1_1
LOAD_MISSION_AUDIO 2 PORN1_2

WHILE NOT HAS_MISSION_AUDIO_LOADED 1
OR NOT HAS_MISSION_AUDIO_LOADED 2
	WAIT 0
ENDWHILE 

// ******************************************START OF Meeting Candy CUTSCENE********************************
//cutscene meeting candy and pimp

SET_PLAYER_CONTROL player1 OFF
SWITCH_WIDESCREEN ON

IF NOT IS_CAR_DEAD player_car_porn1 
	IF LOCATE_CAR_2D player_car_porn1 -448.3 1324.6 30.0 30.0 FALSE 
		SET_CAR_COORDINATES player_car_porn1 -441.9 1337.0 10.7
		SET_CAR_HEADING player_car_porn1 289.8
	ENDIF
ENDIF  
	
CLEAR_AREA_OF_CARS -584.8 1320.7 5.5 -309.7 1360.2 15.5 
SET_CAR_DENSITY_MULTIPLIER 0.0 

SET_PLAYER_COORDINATES player1 -448.3 1324.6 10.7
SET_PLAYER_HEADING player1 19.7
SET_FIXED_CAMERA_POSITION -445.3 1321.8 13.0 0.0 0.0 0.0 
POINT_CAMERA_AT_POINT -450.3 1327.7 12.0 JUMP_CUT

PRINT_NOW ( POR1_26 ) 5000 1 //Here's Candy, looks like she has been with Congressman Shrub again.

//creating candy in car
CREATE_CAR stretch -492.4 1335.8 10.4 candy_stretch_limo
SET_CAR_DRIVING_STYLE candy_stretch_limo 2 
SET_CAR_HEADING candy_stretch_limo 276.1 
CREATE_CHAR_INSIDE_CAR candy_stretch_limo PEDTYPE_CIVMALE HMYRI candy_limo_driver 
SET_CHAR_CAN_BE_SHOT_IN_VEHICLE candy_limo_driver FALSE
CHANGE_CAR_COLOUR candy_stretch_limo CARCOLOUR_YELLOW5 CARCOLOUR_YELLOW5
CREATE_CHAR_AS_PASSENGER candy_stretch_limo PEDTYPE_CIVFEMALE SPECIAL01 2 candy_sexxx
SET_CHAR_AS_PLAYER_FRIEND candy_sexxx player1 TRUE
CLEAR_CHAR_THREAT_SEARCH candy_sexxx 
SET_CHAR_ONLY_DAMAGED_BY_PLAYER candy_sexxx TRUE 
SET_ANIM_GROUP_FOR_CHAR candy_sexxx ANIM_SEXY_WOMANPED
SET_CHAR_RUNNING candy_sexxx TRUE
SET_CHAR_NEVER_TARGETTED candy_sexxx TRUE 
SET_CHAR_IN_PLAYERS_GROUP_CAN_FIGHT candy_sexxx FALSE 
SET_CAR_FORWARD_SPEED candy_stretch_limo 15.0 
SET_CAR_CRUISE_SPEED candy_stretch_limo 15.0
CAR_GOTO_COORDINATES candy_stretch_limo -448.4 1340.6 10.4

//limo pulling up
timerb = 0

pron1_cutscene_part2:
WAIT 0

IF NOT IS_CAR_DEAD candy_stretch_limo 
	IF timerb > 7000 
		GOTO pron1_cutscene_part2_finish
	ENDIF
	IF NOT LOCATE_CAR_3D candy_stretch_limo  -448.4 1340.6 10.4 4.0 4.0 4.0 FALSE
		CAR_GOTO_COORDINATES candy_stretch_limo  -448.4 1340.6 10.4 
	ELSE
		SET_CAR_CRUISE_SPEED candy_stretch_limo 0.0
		GOTO pron1_cutscene_part2_finish
	ENDIF   
ENDIF

GOTO pron1_cutscene_part2

//getting candy out of car
pron1_cutscene_part2_finish:
IF NOT IS_CAR_DEAD candy_stretch_limo 
	IF NOT IS_CHAR_DEAD candy_sexxx 
		SET_CAR_CRUISE_SPEED candy_stretch_limo 0.0
		SET_CHAR_OBJ_LEAVE_CAR candy_sexxx candy_stretch_limo
	ENDIF
ENDIF
	 
getting_candy_out_car:
WAIT 0
	IF NOT IS_CAR_DEAD candy_stretch_limo  
	   	GET_NUMBER_OF_PASSENGERS candy_stretch_limo candy_out_limo
		IF candy_out_limo = 0 
			IF NOT IS_CHAR_DEAD candy_sexxx
				RESTORE_CAMERA_JUMPCUT  
				SET_CHAR_OBJ_GOTO_CHAR_ON_FOOT candy_sexxx scplayer 
				SET_CHAR_OBJ_GOTO_CHAR_ON_FOOT scplayer candy_sexxx
				IF NOT IS_CAR_DEAD candy_stretch_limo
					SET_CAR_CRUISE_SPEED candy_stretch_limo 15.0 
					CAR_GOTO_COORDINATES candy_stretch_limo -338.6 1133.1 8.5 
				ENDIF
//creating pump action pimp car
				CREATE_CAR sentinel -492.4 1335.8 10.4 pap_car
				SET_CAR_HEADING pap_car 276.1
				SET_CAR_DRIVING_STYLE pap_car 2  
				SET_CAR_ONLY_DAMAGED_BY_PLAYER pap_car TRUE
				CREATE_CHAR_INSIDE_CAR pap_car PEDTYPE_CIVMALE WMYPI pap_man
				
				
				GIVE_WEAPON_TO_CHAR pap_man WEAPONTYPE_tec9 30000
				SET_CHAR_ONLY_DAMAGED_BY_PLAYER pap_man TRUE
				CREATE_CHAR_AS_PASSENGER pap_car PEDTYPE_CIVMALE BMYCR 0 pap_guard1 
				GIVE_WEAPON_TO_CHAR pap_guard1 WEAPONTYPE_BASEBALLBAT 1
				CLEAR_CHAR_THREAT_SEARCH pap_guard1
				CREATE_CHAR_AS_PASSENGER pap_car PEDTYPE_CIVMALE BMYCR 1 pap_guard2
				GIVE_WEAPON_TO_CHAR pap_guard2 WEAPONTYPE_BASEBALLBAT 1
				CLEAR_CHAR_THREAT_SEARCH pap_guard2
				CREATE_CHAR_AS_PASSENGER pap_car PEDTYPE_CIVMALE BMYCR 2 pap_guard3 
				GIVE_WEAPON_TO_CHAR pap_guard3 WEAPONTYPE_tec9 30000
				CLEAR_CHAR_THREAT_SEARCH pap_guard3
				ADD_BLIP_FOR_CHAR pap_man pap_man_blip
				SET_CAR_FORWARD_SPEED candy_stretch_limo 15.0 
				SET_CAR_CRUISE_SPEED pap_car 15.0
				CAR_GOTO_COORDINATES pap_car -448.4 1340.6 10.4
			ENDIF
			timerb = 0
			GOTO getting_candy_out_car2
		ELSE
			GOTO getting_candy_out_car
		ENDIF
	ENDIF
GOTO getting_candy_out_car 

//getting candy to walk to player
getting_candy_out_car2:
WAIT 0 
IF timerb > 7000 
	GOTO pron1_cutscene_part1_finish
ENDIF
IF NOT IS_CHAR_DEAD candy_sexxx
	IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 candy_sexxx 2.0 2.0 FALSE
		SET_CHAR_OBJ_NO_OBJ candy_sexxx 
		SET_CHAR_OBJ_NO_OBJ scplayer
		TURN_CHAR_TO_FACE_CHAR scplayer candy_sexxx 
		TURN_CHAR_TO_FACE_PLAYER candy_sexxx player1 
		GOTO pron1_cutscene_part1_finish
	ENDIF
ENDIF
GOTO getting_candy_out_car2 

pron1_cutscene_part1_finish:


SET_FIXED_CAMERA_POSITION -450.2 1328.1 12.8 0.0 0.0 0.0 
POINT_CAMERA_AT_POINT -449.9 1330.8 12.2 JUMP_CUT

SET_CHAR_WAIT_STATE scplayer WAITSTATE_PLAYANIM_CHAT 10000

PRINT_NOW POR1_04 4000 1//PLAYER: Yo, Candy. I'm looking for movie talent -you interested?
PLAY_MISSION_AUDIO 1
WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
	WAIT 0
ENDWHILE
CLEAR_MISSION_AUDIO 1
CLEAR_THIS_PRINT POR1_04 

SET_CHAR_WAIT_STATE scplayer WAITSTATE_FALSE 100
IF NOT IS_CHAR_DEAD candy_sexxx 
	SET_CHAR_WAIT_STATE candy_sexxx WAITSTATE_PLAYANIM_CHAT 10000
ENDIF

IF NOT IS_CHAR_DEAD pap_man
	IF NOT IS_CAR_DEAD pap_car 
		SET_CHAR_OBJ_LEAVE_CAR pap_man pap_car
	ENDIF
ENDIF

PRINT_NOW POR1_05 4000 1//CANDY: Sure! You'd have to talk to my agent...
PLAY_MISSION_AUDIO 2
WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
AND NOT IS_CHAR_DEAD candy_sexxx  
	IF NOT IS_CHAR_DEAD pap_man
		TURN_CHAR_TO_FACE_CHAR pap_man scplayer
	ENDIF 
	WAIT 0
ENDWHILE
CLEAR_MISSION_AUDIO 2
CLEAR_THIS_PRINT POR1_05 

LOAD_MISSION_AUDIO 1 PRN1_3a
LOAD_MISSION_AUDIO 2 PORN1_3

WHILE NOT HAS_MISSION_AUDIO_LOADED 1
OR NOT HAS_MISSION_AUDIO_LOADED 2
	WAIT 0
ENDWHILE 


IF NOT IS_CHAR_DEAD candy_sexxx 
	SET_CHAR_WAIT_STATE candy_sexxx WAITSTATE_FALSE 100
	IF NOT IS_CHAR_DEAD pap_man
		TURN_CHAR_TO_FACE_CHAR candy_sexxx pap_man
	ENDIF
ENDIF

PRINT_NOW POR1_06 4000 1//The HELL are you doin'?
PLAY_MISSION_AUDIO 2
WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
AND NOT IS_CHAR_DEAD pap_man  
	WAIT 0
ENDWHILE
CLEAR_MISSION_AUDIO 2
CLEAR_THIS_PRINT POR1_06 

TURN_CHAR_TO_FACE_COORD scplayer -448.4 1340.6 10.4 
//SET_CHAR_WAIT_STATE scplayer WAITSTATE_PLAYANIM_CHAT 10000
SET_CHAR_OBJ_GOTO_COORD_ON_FOOT scplayer -448.4 1333.6 


PRINT_NOW POR1_07 4000 1//You should have stayed at home today!
PLAY_MISSION_AUDIO 1
WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
	WAIT 0
ENDWHILE
CLEAR_MISSION_AUDIO 1
CLEAR_THIS_PRINT POR1_07 

//SET_CHAR_WAIT_STATE scplayer WAITSTATE_FALSE 100

LOAD_MISSION_AUDIO 2 PRN1_21

WHILE NOT HAS_MISSION_AUDIO_LOADED 2
	WAIT 0
ENDWHILE 

IF NOT IS_CHAR_DEAD pap_man
	IF NOT IS_CAR_DEAD pap_car 
		SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER pap_man pap_car
	ENDIF
ENDIF

PRINT_NOW POR1_7b 4000 1//Can you believe this asshole?

PLAY_MISSION_AUDIO 2
WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
AND NOT IS_CHAR_DEAD pap_man  
	WAIT 0
ENDWHILE
CLEAR_MISSION_AUDIO 2
CLEAR_THIS_PRINT POR1_7b 


//getting guards out of car to come after player1
IF NOT IS_CHAR_DEAD pap_guard1 
	IF NOT IS_CHAR_DEAD pap_guard2 
		IF NOT IS_CHAR_DEAD pap_guard3
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT pap_guard1 player1
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT pap_guard2 player1
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT pap_guard3 player1
		ENDIF
	ENDIF
ENDIF

//setting candy to duck
IF NOT IS_CHAR_DEAD candy_sexxx
	SET_CHAR_STAY_IN_SAME_PLACE candy_sexxx TRUE
	candy_sexxx_waitstate = 1
ELSE
	PRINT_NOW ( POR1_03 ) 5000 1 //Candy is dead!
	GOTO mission_failed_porn1 
ENDIF

WAIT 1000

//deleting candy car
IF NOT IS_CAR_DEAD candy_stretch_limo
	IF NOT IS_CAR_ON_SCREEN candy_stretch_limo
		IF NOT IS_CHAR_DEAD candy_limo_driver 
			DELETE_CHAR candy_limo_driver 
		ENDIF
		DELETE_CAR candy_stretch_limo
	ENDIF
ENDIF 

SET_CHAR_OBJ_NO_OBJ scplayer 
SET_CAR_DENSITY_MULTIPLIER 1.0 
MARK_CAR_AS_NO_LONGER_NEEDED player_car_porn1 
RESTORE_CAMERA_JUMPCUT
SET_CAMERA_BEHIND_PLAYER
SET_PLAYER_CONTROL player1 ON
SWITCH_WIDESCREEN OFF
REMOVE_BLIP candy_sexxx_blip
PRINT_NOW ( POR1_02 ) 7000 1 //Go and take out Candy's pimp, then return and pick up Candy.
IF NOT IS_CAR_DEAD pap_car 
	ADD_STUCK_CAR_CHECK pap_car 1.5 4000
ENDIF
// ******************************************END OF Meeting Candy CUTSCENE********************************



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Main Loop//////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
porn1_loop:

WAIT 0


/*
//////////TEST////////////////
IF IS_BUTTON_PRESSED PAD1 CROSS
	IF NOT IS_CAR_DEAD pap_car 
		EXPLODE_CAR pap_car
	ENDIF
ENDIF 
*/


IF porn1_goals = 0
	IF NOT IS_CHAR_DEAD pap_man
		IF NOT IS_CAR_DEAD pap_car

			IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 pap_car 80.0 80.0 FALSE  
				SET_CAR_ONLY_DAMAGED_BY_PLAYER pap_car TRUE
			ELSE
				SET_CAR_ONLY_DAMAGED_BY_PLAYER pap_car FALSE
			ENDIF


//if player1 is in range, pimp car will stop and pimp peeps will get out

			GET_CAR_HEALTH pap_car pap_car_health
			IF pap_car_health > 300	
				IF IS_CHAR_IN_CAR pap_man pap_car 
					GET_NUMBER_OF_PASSENGERS pap_car pap_guards_count
					IF pap_guards_count = 3
						IF LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 pap_car 50.0 50.0 FALSE
							IF timera_reset = 0
								timera = 0
								timera_reset = 1
							ENDIF
							SET_CAR_CRUISE_SPEED pap_car 0.0
							IF NOT IS_PLAYER_IN_ANY_CAR player1
								IF NOT IS_CHAR_DEAD pap_guard1 
									IF NOT IS_CHAR_DEAD pap_guard2 
										IF NOT IS_CHAR_DEAD pap_guard3
											SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT pap_guard1 player1
											SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT pap_guard2 player1
											SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT pap_guard3 player1
											pap_guards_count = 0
											random_car_wander = 0
											timera_reset = 0											
										ENDIF
									ENDIF
								ENDIF
							ELSE
								IF timera > 3000 
									IF NOT IS_CHAR_DEAD pap_guard1 
										IF NOT IS_CHAR_DEAD pap_guard2 
											IF NOT IS_CHAR_DEAD pap_guard3
												SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT pap_guard1 player1
												SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT pap_guard2 player1
												SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT pap_guard3 player1
												pap_guards_count = 0
												random_car_wander = 0
												timera_reset = 0											
											ENDIF
										ENDIF
									ENDIF
								ENDIF
							ENDIF
						ELSE
							SET_CAR_CRUISE_SPEED pap_car 20.0
						ENDIF
					ELSE
						IF random_car_wander = 0
							CAR_WANDER_RANDOMLY pap_car
							random_car_wander = 1
						ENDIF
						SET_CAR_CRUISE_SPEED pap_car 40.0  //pimp car will then speed up and new pimp guards will be created
						IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 pap_car 100.0 100.0 FALSE
							IF NOT IS_CAR_ON_SCREEN pap_car
								IF NOT IS_CHAR_DEAD pap_guard1
									IF NOT IS_CHAR_IN_CAR pap_guard1 pap_car 	
										IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 pap_guard1 60.0 60.0 FALSE 
											EXPLODE_CHAR_HEAD pap_guard1 
											MARK_CHAR_AS_NO_LONGER_NEEDED pap_guard1
											CREATE_CHAR_AS_PASSENGER pap_car PEDTYPE_CIVMALE BMYCR 0 pap_guard1
											GIVE_WEAPON_TO_CHAR pap_guard1 WEAPONTYPE_tec9 30000
										ENDIF 
									ENDIF
								ELSE
									MARK_CHAR_AS_NO_LONGER_NEEDED pap_guard1
									CREATE_CHAR_AS_PASSENGER pap_car PEDTYPE_CIVMALE BMYCR 0 pap_guard1
									GIVE_WEAPON_TO_CHAR pap_guard1 WEAPONTYPE_tec9 30000
								ENDIF
								IF NOT IS_CHAR_DEAD pap_guard2
									IF NOT IS_CHAR_IN_CAR pap_guard2 pap_car 	
										IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 pap_guard2 60.0 60.0 FALSE 
											EXPLODE_CHAR_HEAD pap_guard2 
											MARK_CHAR_AS_NO_LONGER_NEEDED pap_guard2
											CREATE_CHAR_AS_PASSENGER pap_car PEDTYPE_CIVMALE BMYCR 1 pap_guard2
											GIVE_WEAPON_TO_CHAR pap_guard2 WEAPONTYPE_tec9 30000
										ENDIF 
									ENDIF
								ELSE  
									MARK_CHAR_AS_NO_LONGER_NEEDED pap_guard2
									CREATE_CHAR_AS_PASSENGER pap_car PEDTYPE_CIVMALE BMYCR 1 pap_guard2
									GIVE_WEAPON_TO_CHAR pap_guard2 WEAPONTYPE_tec9 30000
								ENDIF
								IF NOT IS_CHAR_DEAD pap_guard3
									IF NOT IS_CHAR_IN_CAR pap_guard3 pap_car 	
										IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 pap_guard3 60.0 60.0 FALSE 
											EXPLODE_CHAR_HEAD pap_guard3 
											MARK_CHAR_AS_NO_LONGER_NEEDED pap_guard3
											CREATE_CHAR_AS_PASSENGER pap_car PEDTYPE_CIVMALE BMYCR 2 pap_guard3
											GIVE_WEAPON_TO_CHAR pap_guard3 WEAPONTYPE_tec9 30000
										ENDIF 
									ENDIF
								ELSE  
									MARK_CHAR_AS_NO_LONGER_NEEDED pap_guard3
									CREATE_CHAR_AS_PASSENGER pap_car PEDTYPE_CIVMALE BMYCR 2 pap_guard3
									GIVE_WEAPON_TO_CHAR pap_guard3 WEAPONTYPE_tec9 30000
								ENDIF
							ENDIF
						ENDIF
					ENDIF
					IF porn1_goals = 0
						IF IS_CAR_STUCK	pap_car
							SET_CAR_TEMP_ACTION pap_car TEMPACT_REVERSE 1000
						ENDIF
					ENDIF
					
					IF IS_CAR_UPSIDEDOWN pap_car
						SET_CHAR_OBJ_LEAVE_CAR pap_man pap_car
						REMOVE_STUCK_CAR_CHECK pap_car
						porn1_goals = 1
					ENDIF
				ELSE
					REMOVE_STUCK_CAR_CHECK pap_car
					porn1_goals = 1
				ENDIF
			ELSE
				SET_CHAR_OBJ_LEAVE_CAR pap_man pap_car
				REMOVE_STUCK_CAR_CHECK pap_car 
				porn1_goals = 1
			ENDIF
		ENDIF
	ELSE
		GOTO next_porn_bit
	ENDIF
ENDIF

//if pimp is out of car, he will search for another one then go get more pimp guards

IF porn1_goals = 1
	IF NOT IS_CHAR_DEAD pap_man 
		IF pap_blip_flag = 0
			REMOVE_BLIP pap_man_blip
			ADD_BLIP_FOR_CHAR pap_man pap_man_blip
			MARK_CAR_AS_NO_LONGER_NEEDED pap_car
			pap_blip_flag = 1
		ENDIF
		IF NOT IS_CHAR_SITTING_IN_ANY_CAR pap_man
			MARK_CAR_AS_NO_LONGER_NEEDED pap_car
			pap_man_getting_car://loop until pap_man gets into a car
			WAIT 0
			IF NOT IS_CHAR_DEAD	pap_man  
				GET_CHAR_COORDINATES pap_man papcar_coordx papcar_coordy papcar_coordz
				papcar_coord2x = papcar_coordx + 20.0
				papcar_coord2y = papcar_coordy + 20.0
				papcar_coordx = papcar_coordx - 20.0
				papcar_coordy = papcar_coordy - 20.0
				GET_RANDOM_CAR_OF_TYPE_IN_AREA papcar_coordx papcar_coordy papcar_coord2x papcar_coord2y -1 pap_car
				IF pap_car = -1
					MARK_CAR_AS_NO_LONGER_NEEDED pap_car
					SET_CHAR_OBJ_FLEE_ON_FOOT_TILL_SAFE pap_man 
					GOTO pap_man_getting_car 
				ELSE
					GET_MAXIMUM_NUMBER_OF_PASSENGERS pap_car pap_guards_count
					IF pap_guards_count < 3
						MARK_CAR_AS_NO_LONGER_NEEDED pap_car
						SET_CHAR_OBJ_NO_OBJ pap_man
						SET_CHAR_OBJ_FLEE_ON_FOOT_TILL_SAFE pap_man 
						GOTO pap_man_getting_car 
					ELSE
						GET_CAR_HEALTH pap_car pap_car_health
						IF pap_car_health < 300
							MARK_CAR_AS_NO_LONGER_NEEDED pap_car
							SET_CHAR_OBJ_FLEE_ON_FOOT_TILL_SAFE pap_man 
							GOTO pap_man_getting_car 
						ELSE	
							LOCK_CAR_DOORS pap_car CARLOCK_UNLOCKED
							SET_CAR_CRUISE_SPEED pap_car 0.0
							SET_CHAR_OBJ_NO_OBJ pap_man 
							SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER pap_man pap_car
							SET_CHAR_RUNNING pap_man TRUE
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ELSE
			REMOVE_BLIP pap_man_blip
			IF NOT IS_CAR_DEAD pap_car
				ADD_BLIP_FOR_CHAR pap_man pap_man_blip
				SET_CAR_DRIVING_STYLE pap_car 2 
				ADD_STUCK_CAR_CHECK pap_car 1.5 4000
			ENDIF
			pap_blip_flag = 0
			porn1_goals = 0
			random_car_wander = 0
		ENDIF
	ELSE
		GOTO next_porn_bit
	ENDIF
ENDIF

//checking candy's state

IF NOT IS_CHAR_DEAD candy_sexxx
	IF LOCATE_STOPPED_CHAR_ON_FOOT_2D candy_sexxx -448.3 1324.6 3.0 3.0 0
		IF candy_sexxx_waitstate = 0
			TURN_CHAR_TO_FACE_COORD candy_sexxx  -448.4 1340.6 10.7
			SET_CHAR_STAY_IN_SAME_PLACE candy_sexxx TRUE
			candy_sexxx_waitstate = 1
		ENDIF
	ELSE
		SET_CHAR_STAY_IN_SAME_PLACE candy_sexxx FALSE
		SET_CHAR_OBJ_RUN_TO_COORD candy_sexxx -448.3 1324.6 
		candy_sexxx_waitstate = 0
	ENDIF
ELSE
	PRINT_NOW ( POR1_03 ) 5000 1 //Candy is dead!
	GOTO mission_failed_porn1
ENDIF

GOTO porn1_loop
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Main Loop//////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

next_porn_bit:
PRINT_NOW ( POR1_24 ) 7000 1 //Go back and collect Candy.

//REMOVE_BLIP pap_car_blip
REMOVE_BLIP pap_man_blip

//creating pornstar that player1 goes to talk to 
IF NOT IS_CHAR_DEAD candy_sexxx 
	SET_CHAR_WAIT_STATE candy_sexxx WAITSTATE_FALSE 1
	SET_CHAR_HEADING candy_sexxx 14.9  	
	SET_CHAR_STAY_IN_SAME_PLACE candy_sexxx FALSE
	ADD_BLIP_FOR_COORD -448.3 1324.6 10.7 candy_sexxx_blip
ENDIF  

WHILE NOT LOCATE_PLAYER_ON_FOOT_3D player1 -448.3 1326.6 10.7 1.0 1.0 2.0 TRUE
	WAIT 0
	IF IS_CHAR_DEAD candy_sexxx
		PRINT_NOW ( POR1_03 ) 5000 1 //Candy is dead!
		GOTO mission_failed_porn1
	ELSE
		IF LOCATE_STOPPED_CHAR_ON_FOOT_2D candy_sexxx -448.3 1324.6 3.0 3.0 0
			IF candy_sexxx_waitstate = 0
				TURN_CHAR_TO_FACE_COORD candy_sexxx  -448.4 1340.6 10.7
				SET_CHAR_STAY_IN_SAME_PLACE candy_sexxx TRUE
				candy_sexxx_waitstate = 1
			ENDIF
		ELSE
			SET_CHAR_STAY_IN_SAME_PLACE candy_sexxx FALSE
			SET_CHAR_OBJ_RUN_TO_COORD candy_sexxx -448.3 1324.6 
			candy_sexxx_waitstate = 0
		ENDIF
	ENDIF
ENDWHILE

SET_PLAYER_AS_LEADER candy_sexxx player1
flag_candy_sexxx_in_group = 1

REMOVE_BLIP candy_sexxx_blip 

LOAD_MISSION_AUDIO 1 PRN1_16
WHILE NOT HAS_MISSION_AUDIO_LOADED 1
	WAIT 0
ENDWHILE 

PRINT_NOW POR1_27 4000 1//Come on, Let's go.

PLAY_MISSION_AUDIO 1
WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
AND NOT IS_CHAR_DEAD candy_sexxx  
	WAIT 0
ENDWHILE
CLEAR_MISSION_AUDIO 1
CLEAR_THIS_PRINT POR1_19 

PRINT ( POR1_12 ) 5000 1 //Take Candy with you to meet up with Mercedes.


MARK_CHAR_AS_NO_LONGER_NEEDED pap_guard1
MARK_CHAR_AS_NO_LONGER_NEEDED pap_guard2
MARK_CHAR_AS_NO_LONGER_NEEDED pap_guard3
MARK_CAR_AS_NO_LONGER_NEEDED pap_car
//creating mercedes that player1 goes to talk to 
CREATE_CHAR PEDTYPE_CIVFEMALE SPECIAL02 -902.3 800.2 10.4 mercedes
SET_CHAR_HEADING mercedes 95.9 
SET_CHAR_AS_PLAYER_FRIEND mercedes player1 TRUE
SET_ANIM_GROUP_FOR_CHAR mercedes ANIM_SEXY_WOMANPED
SET_CHAR_RUNNING mercedes TRUE
SET_CHAR_IN_PLAYERS_GROUP_CAN_FIGHT mercedes FALSE 
SET_CHAR_WAIT_STATE mercedes WAITSTATE_PLAYANIM_CHAT 86400000 
SET_CHAR_NEVER_TARGETTED mercedes TRUE 


//creating fake car player can use
CREATE_CAR sentinel -858.0 796.5 10.9 pap_car
SET_CAR_HEADING pap_car 187.1 

//creating random chars chatting in corner of pizza place
CREATE_RANDOM_CHAR -887.5 800.5 10.3 pap_guard1
CREATE_RANDOM_CHAR -888.5 800.5 10.3 pap_guard2
CREATE_RANDOM_CHAR -888.6 801.2 10.3 pap_guard3
SET_CHARS_CHATTING pap_guard1 pap_guard2 86400000 
SET_CHARS_CHATTING pap_guard3 pap_guard2 86400000 


ADD_BLIP_FOR_COORD -900.8 796.0 10.3 mercedes_blip

WHILE NOT LOCATE_PLAYER_ON_FOOT_3D player1 -900.8 796.0 10.3 1.0 1.0 2.0 flag_candy_sexxx_in_group
	WAIT 0

	IF NOT IS_CHAR_DEAD candy_sexxx
		IF flag_candy_sexxx_in_group = 1
	        IF NOT IS_CHAR_IN_PLAYERS_GROUP candy_sexxx player1
				
				
				LOAD_MISSION_AUDIO 1 PRN1_13
				WHILE NOT HAS_MISSION_AUDIO_LOADED 1
					WAIT 0
				ENDWHILE 
		        PRINT_NOW POR1_20 4000 1//Tommy where are you going?  Get back here!
				PLAY_MISSION_AUDIO 1
				WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
				AND NOT IS_CHAR_DEAD candy_sexxx  
					WAIT 0
				ENDWHILE
				CLEAR_MISSION_AUDIO 1
				CLEAR_THIS_PRINT POR1_20 


				PRINT POR1_25 4000 1 //You have left Candy behind, go and get her.
		        REMOVE_BLIP mercedes_blip
		        REMOVE_BLIP candy_sexxx_blip
				IF NOT IS_CHAR_DEAD candy_sexxx
		        	ADD_BLIP_FOR_CHAR candy_sexxx candy_sexxx_blip
				ENDIF
		        flag_candy_sexxx_in_group = 0
		    ENDIF
		ENDIF
		IF flag_candy_sexxx_in_group = 0 
		    IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 candy_sexxx 8.0 8.0 8.0 FALSE
		        SET_PLAYER_AS_LEADER candy_sexxx player1

				LOAD_MISSION_AUDIO 2 PRN1_12
				WHILE NOT HAS_MISSION_AUDIO_LOADED 2
					WAIT 0
				ENDWHILE 
		        PRINT_NOW POR1_19 4000 1//hey!
				PLAY_MISSION_AUDIO 2
				WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
				AND NOT IS_CHAR_DEAD candy_sexxx  
					WAIT 0
				ENDWHILE
				CLEAR_MISSION_AUDIO 2
				CLEAR_THIS_PRINT POR1_19 

		        REMOVE_BLIP mercedes_blip
		        REMOVE_BLIP candy_sexxx_blip
		        IF NOT IS_CHAR_DEAD mercedes 
		        	ADD_BLIP_FOR_CHAR mercedes mercedes_blip
				ENDIF
		        flag_candy_sexxx_in_group = 1
		    ENDIF
		ENDIF
	
		IF candy_tits1 < 2
			IF IS_CHAR_IN_PLAYERS_GROUP candy_sexxx player1
				IF IS_PLAYER_IN_ANY_CAR player1 
					STORE_CAR_PLAYER_IS_IN_NO_SAVE player1 tits_car  	 
					IF IS_CHAR_IN_CAR candy_sexxx tits_car 
						GET_CAR_HEALTH tits_car tits_car_health
					 	GET_CAR_SPEED tits_car tits_car_speed
					 	IF tits_car_speed > 15.0
						 	IF candy_tits1 = 0 
							 	IF tits_car_health < 700
							 		LOAD_MISSION_AUDIO 1 PRN1_17 
									WHILE NOT HAS_MISSION_AUDIO_LOADED 1
										WAIT 0
									ENDWHILE 
									PRINT_NOW POR1_28 4000 1//Tommy be careful! My implants aren't insured yet!
									PLAY_MISSION_AUDIO 1
									WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
									AND NOT IS_CHAR_DEAD candy_sexxx  
										WAIT 0
									ENDWHILE
									CLEAR_MISSION_AUDIO 1
									CLEAR_THIS_PRINT POR1_28
								 	candy_tits1 = 1
								ENDIF
							ENDIF
							IF candy_tits1 = 1 
								IF tits_car_health < 400
									LOAD_MISSION_AUDIO 1 PRN1_19 
									WHILE NOT HAS_MISSION_AUDIO_LOADED 1
										WAIT 0
									ENDWHILE 
									PRINT_NOW POR1_30 4000 1//I can't do porno after this!
									PLAY_MISSION_AUDIO 1
									WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
									AND NOT IS_CHAR_DEAD candy_sexxx  
										WAIT 0
									ENDWHILE
									CLEAR_MISSION_AUDIO 1
									CLEAR_THIS_PRINT POR1_30
									candy_tits1 = 2
								ENDIF
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF		
		ENDIF			
	ELSE
		PRINT_NOW ( POR1_03 ) 5000 1 //Candy is dead!
		GOTO mission_failed_porn1
	ENDIF

	IF IS_CHAR_DEAD mercedes
		PRINT_NOW ( POR1_18 ) 5000 1 //Mercedes is dead!
		GOTO mission_failed_porn1
	ELSE
		SET_CHAR_WAIT_STATE mercedes WAITSTATE_USE_ATM 86400000
	ENDIF 
	
ENDWHILE

REMOVE_BLIP mercedes_blip


// ******************************************START OF Meeting Mercedes CUTSCENE********************************
SET_PLAYER_COORDINATES player1 -900.8 796.0 10.3
SET_PED_DENSITY_MULTIPLIER 0.0 
IF NOT IS_CHAR_DEAD mercedes 
	SET_CHAR_COORDINATES mercedes -902.3 800.2 10.4
ENDIF 

SET_PLAYER_CONTROL player1 OFF
SWITCH_WIDESCREEN ON

SET_FIXED_CAMERA_POSITION -897.3 799.7 12.5 0.0 0.0 0.0 
POINT_CAMERA_AT_POINT -902.4 798.0 11.4 JUMP_CUT

LOAD_MISSION_AUDIO 1 PORN1_4
LOAD_MISSION_AUDIO 2 PORN1_5

WHILE NOT HAS_MISSION_AUDIO_LOADED 1
OR NOT HAS_MISSION_AUDIO_LOADED 2
	WAIT 0
ENDWHILE 

IF NOT IS_CHAR_DEAD mercedes 
	TURN_CHAR_TO_FACE_CHAR scplayer mercedes
ENDIF
SET_CHAR_WAIT_STATE scplayer WAITSTATE_PLAYANIM_CHAT 10000

PRINT_NOW POR1_08 4000 1//Hey Mercedes!
PLAY_MISSION_AUDIO 1
WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
	WAIT 0
ENDWHILE
CLEAR_MISSION_AUDIO 1
CLEAR_THIS_PRINT POR1_08 

SET_CHAR_WAIT_STATE scplayer WAITSTATE_FALSE 100
IF NOT IS_CHAR_DEAD mercedes 
	CLEAR_CHAR_WAIT_STATE mercedes
ENDIF

WAIT 100

IF NOT IS_CHAR_DEAD mercedes 
	SET_CHAR_OBJ_GOTO_CHAR_ON_FOOT mercedes scplayer 
ENDIF

PRINT_NOW POR1_09 4000 1//Hey Tommy! You wanna party?
PLAY_MISSION_AUDIO 2
WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
AND NOT IS_CHAR_DEAD mercedes  
	WAIT 0
ENDWHILE
CLEAR_MISSION_AUDIO 2
CLEAR_THIS_PRINT POR1_09 

LOAD_MISSION_AUDIO 1 PORN1_6
LOAD_MISSION_AUDIO 2 PORN1_7

WHILE NOT HAS_MISSION_AUDIO_LOADED 1
OR NOT HAS_MISSION_AUDIO_LOADED 2
	WAIT 0
ENDWHILE 

SET_CHAR_WAIT_STATE scplayer WAITSTATE_PLAYANIM_CHAT 10000

PRINT_NOW POR1_10 4000 1//Not now sweets. You interested in doing some movies?
PLAY_MISSION_AUDIO 1
WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
	WAIT 0
ENDWHILE
CLEAR_MISSION_AUDIO 1
CLEAR_THIS_PRINT POR1_10 

SET_CHAR_WAIT_STATE scplayer WAITSTATE_FALSE 100

PRINT_NOW POR1_11 4000 1//Of course. As long as it's cheap and sleazy.
PLAY_MISSION_AUDIO 2
WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
AND NOT IS_CHAR_DEAD mercedes  
	WAIT 0
ENDWHILE
CLEAR_MISSION_AUDIO 2
CLEAR_THIS_PRINT POR1_11 

SET_CHAR_WAIT_STATE scplayer WAITSTATE_PLAYANIM_CHAT 10000

LOAD_MISSION_AUDIO 1 PORN1_8

WHILE NOT HAS_MISSION_AUDIO_LOADED 1
	WAIT 0
ENDWHILE 

PRINT_NOW POR1_14 4000 1//You're hired! Get in.
PLAY_MISSION_AUDIO 1
WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
	WAIT 0
ENDWHILE
CLEAR_MISSION_AUDIO 1
CLEAR_THIS_PRINT POR1_14 

SET_CHAR_WAIT_STATE scplayer WAITSTATE_FALSE 100

SET_PED_DENSITY_MULTIPLIER 1.0 
IF NOT IS_CHAR_DEAD mercedes 
	SET_PLAYER_AS_LEADER mercedes player1
ENDIF
flag_mercedes_in_group = 1

RESTORE_CAMERA_JUMPCUT
SET_PLAYER_CONTROL player1 ON
SWITCH_WIDESCREEN OFF
// ******************************************End OF Meeting Mercedes CUTSCENE**********************************

PRINT ( POR1_13 ) 5000 1 //Take the girls back to the Studio for some casting couch trials.

//go back to porn studios

ADD_BLIP_FOR_COORD -60.2 934.5 10.6 pron_studio 

going_to_studio:
WAIT 0
IF NOT IS_CHAR_DEAD candy_sexxx
	IF candy_tits2 < 2
		IF IS_CHAR_IN_PLAYERS_GROUP candy_sexxx player1
			IF IS_PLAYER_IN_ANY_CAR player1 
				STORE_CAR_PLAYER_IS_IN_NO_SAVE player1 tits_car  	 
				IF IS_CHAR_IN_CAR candy_sexxx tits_car 
					GET_CAR_HEALTH tits_car tits_car_health
				 	GET_CAR_SPEED tits_car tits_car_speed
				 	IF tits_car_speed > 15.0
						IF candy_tits2 = 0 
						 	IF tits_car_health < 700
						 		LOAD_MISSION_AUDIO 1 PRN1_18 
								WHILE NOT HAS_MISSION_AUDIO_LOADED 1
									WAIT 0
								ENDWHILE 
								PRINT_NOW POR1_29 4000 1//You call that driving?
								PLAY_MISSION_AUDIO 1
								WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
								AND NOT IS_CHAR_DEAD candy_sexxx  
									WAIT 0
								ENDWHILE
								CLEAR_MISSION_AUDIO 1
								CLEAR_THIS_PRINT POR1_29
							 	candy_tits2 = 1
							ENDIF
						ENDIF
						IF candy_tits2 = 1 
							IF tits_car_health < 400
								LOAD_MISSION_AUDIO 1 PRN1_20 
								WHILE NOT HAS_MISSION_AUDIO_LOADED 1
									WAIT 0
								ENDWHILE 
								PRINT_NOW POR1_31 4000 1//What? Are you trying to kill me? I thought I was the star!
								PLAY_MISSION_AUDIO 1
								WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
								AND NOT IS_CHAR_DEAD candy_sexxx  
									WAIT 0
								ENDWHILE
								CLEAR_MISSION_AUDIO 1
								CLEAR_THIS_PRINT POR1_31
								candy_tits2 = 2
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF		
	ENDIF
ENDIF			

IF NOT IS_CHAR_DEAD candy_sexxx
	IF flag_candy_sexxx_in_group = 1
        IF NOT IS_CHAR_IN_PLAYERS_GROUP candy_sexxx player1

			LOAD_MISSION_AUDIO 1 PRN1_13
			WHILE NOT HAS_MISSION_AUDIO_LOADED 1
				WAIT 0
			ENDWHILE 
	        PRINT_NOW POR1_20 4000 1//Tommy where are you going?  Get back here!
			PLAY_MISSION_AUDIO 1
			WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
			AND NOT IS_CHAR_DEAD candy_sexxx  
				WAIT 0
			ENDWHILE
			CLEAR_MISSION_AUDIO 1
			CLEAR_THIS_PRINT POR1_20
			 
			PRINT POR1_25 4000 1 //You have left Candy behind, go and get her.
	        REMOVE_BLIP candy_sexxx_blip
	        REMOVE_BLIP pron_studio
			IF NOT IS_CHAR_DEAD candy_sexxx
	        	ADD_BLIP_FOR_CHAR candy_sexxx candy_sexxx_blip
			ENDIF
	        flag_candy_sexxx_in_group = 0
	    ENDIF
	ENDIF
	IF flag_candy_sexxx_in_group = 0 
	    IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 candy_sexxx 8.0 8.0 8.0 FALSE
	        SET_PLAYER_AS_LEADER candy_sexxx player1
			
			LOAD_MISSION_AUDIO 2 PRN1_12
			WHILE NOT HAS_MISSION_AUDIO_LOADED 2
				WAIT 0
			ENDWHILE
	        PRINT_NOW POR1_19 4000 1//hey!
			PLAY_MISSION_AUDIO 2
			WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
			AND NOT IS_CHAR_DEAD candy_sexxx  
				WAIT 0
			ENDWHILE
			CLEAR_MISSION_AUDIO 2
			CLEAR_THIS_PRINT POR1_19 

	        REMOVE_BLIP candy_sexxx_blip
	        REMOVE_BLIP pron_studio
			IF flag_mercedes_in_group = 1
	        	ADD_BLIP_FOR_COORD -60.2 934.5 10.6 pron_studio
			ENDIF
	        flag_candy_sexxx_in_group = 1
	    ENDIF
	ENDIF
ELSE
	PRINT_NOW ( POR1_03 ) 5000 1 //Candy is dead!
	GOTO mission_failed_porn1
ENDIF

IF NOT IS_CHAR_DEAD mercedes
	IF flag_mercedes_in_group = 1
        IF NOT IS_CHAR_IN_PLAYERS_GROUP mercedes player1
			
			LOAD_MISSION_AUDIO 1 PRN1_14
			WHILE NOT HAS_MISSION_AUDIO_LOADED 1
				WAIT 0
			ENDWHILE 
	        PRINT_NOW POR1_21 4000 1//Where are you going?
			PLAY_MISSION_AUDIO 1
			WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
			AND NOT IS_CHAR_DEAD mercedes  
				WAIT 0
			ENDWHILE
			CLEAR_MISSION_AUDIO 1
			CLEAR_THIS_PRINT POR1_21
			 
	        PRINT_NOW TAXW3_1 4000 1// Go and pick up Mercedes.
	        REMOVE_BLIP mercedes_blip
	        REMOVE_BLIP pron_studio
			IF NOT IS_CHAR_DEAD mercedes
	        	ADD_BLIP_FOR_CHAR mercedes mercedes_blip
			ENDIF
	        flag_mercedes_in_group = 0
	    ENDIF
	ENDIF
	IF flag_mercedes_in_group = 0 
	    IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 mercedes 8.0 8.0 8.0 FALSE
	        SET_PLAYER_AS_LEADER mercedes player1
			
			LOAD_MISSION_AUDIO 2 PRN1_15
			WHILE NOT HAS_MISSION_AUDIO_LOADED 2
				WAIT 0
			ENDWHILE
	        PRINT_NOW POR1_22 4000 1//Tommy, when are we going to spend some time alone together?
			PLAY_MISSION_AUDIO 2
			WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
			AND NOT IS_CHAR_DEAD mercedes  
				WAIT 0
			ENDWHILE
			CLEAR_MISSION_AUDIO 2
			CLEAR_THIS_PRINT POR1_22
			 
	        REMOVE_BLIP mercedes_blip
	        REMOVE_BLIP pron_studio
			IF flag_candy_sexxx_in_group = 1
		        ADD_BLIP_FOR_COORD -60.2 934.5 10.6 pron_studio
			ENDIF
	        flag_mercedes_in_group = 1
	    ENDIF
	ENDIF
ELSE
	PRINT_NOW ( POR1_18 ) 5000 1 //Mercedes is dead!
	GOTO mission_failed_porn1
ENDIF

IF flag_mercedes_in_group = 1
	IF flag_candy_sexxx_in_group = 1 
		IF NOT IS_CHAR_DEAD candy_sexxx
			IF NOT IS_CHAR_DEAD mercedes
				IF LOCATE_PLAYER_ANY_MEANS_3D player1 -65.0 934.1 9.8 5.0 5.0 5.0 TRUE
					IF LOCATE_CHAR_ANY_MEANS_3D candy_sexxx -65.0 934.1 9.8 5.0 5.0 5.0 FALSE
						IF LOCATE_CHAR_ANY_MEANS_3D mercedes -65.0 934.1 9.8 5.0 5.0 5.0 FALSE
							IF IS_PLAYER_IN_ANY_CAR player1 
								STORE_CAR_PLAYER_IS_IN player1 player_car_porn1
								GET_CAR_HEADING player_car_porn1 player_z
							ENDIF
							GOTO final_porn2_cutscene
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF

GOTO going_to_studio
final_porn2_cutscene:
// ******************************************START OF dropping bints at porn studios CUTSCENE********************************
SET_PLAYER_CONTROL player1 OFF
SWITCH_WIDESCREEN ON

IF NOT IS_CAR_DEAD player_car_porn1
	SET_CAR_COORDINATES player_car_porn1 -54.0 942.1 9.8
	SET_CAR_HEADING player_car_porn1 player_z
ENDIF  

SET_FIXED_CAMERA_POSITION -50.7 927.4 10.1 0.0 0.0 0.0 
POINT_CAMERA_AT_POINT -85.3 960.7 22.7 JUMP_CUT

LOAD_MISSION_AUDIO 1 PRN1_10
LOAD_MISSION_AUDIO 2 PORN1_9

WHILE NOT HAS_MISSION_AUDIO_LOADED 1
OR NOT HAS_MISSION_AUDIO_LOADED 2
	WAIT 0
ENDWHILE 

PRINT_NOW POR1_15 4000 1//You coming in for a warm-up!?
PLAY_MISSION_AUDIO 2
WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
AND NOT IS_CHAR_DEAD mercedes  
	WAIT 0
ENDWHILE
CLEAR_MISSION_AUDIO 2
CLEAR_THIS_PRINT POR1_15 

PRINT_NOW POR1_16 4000 1//Maybe later...
PLAY_MISSION_AUDIO 1
WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
	WAIT 0
ENDWHILE
CLEAR_MISSION_AUDIO 1
CLEAR_THIS_PRINT POR1_16 

IF NOT IS_CHAR_DEAD candy_sexxx 
	LEAVE_GROUP candy_sexxx
	IF IS_CHAR_IN_ANY_CAR candy_sexxx
		SET_CHAR_OBJ_LEAVE_ANY_CAR candy_sexxx
	ENDIF
ENDIF 
IF NOT IS_CHAR_DEAD mercedes
	LEAVE_GROUP mercedes 
	IF IS_CHAR_IN_ANY_CAR mercedes
		SET_CHAR_OBJ_LEAVE_ANY_CAR mercedes 
	ENDIF
ENDIF


getting_peeps_out_of_car:
IF NOT IS_CHAR_DEAD candy_sexxx
ENDIF

WHILE IS_CHAR_IN_ANY_CAR candy_sexxx
WAIT 0
	IF NOT IS_CHAR_DEAD candy_sexxx
	ENDIF
ENDWHILE  

IF NOT IS_CHAR_DEAD mercedes
ENDIF

WHILE IS_CHAR_IN_ANY_CAR mercedes
WAIT 0
	IF NOT IS_CHAR_DEAD mercedes
	ENDIF
ENDWHILE  

IF NOT IS_CHAR_DEAD candy_sexxx
	SET_CHAR_OBJ_NO_OBJ candy_sexxx    
	SET_CHAR_OBJ_GOTO_COORD_ON_FOOT candy_sexxx -75.25 930.9
ENDIF

IF NOT IS_CHAR_DEAD mercedes 
	SET_CHAR_OBJ_NO_OBJ mercedes    
	SET_CHAR_OBJ_GOTO_COORD_ON_FOOT mercedes -75.25 930.9 
ENDIF

SET_FIXED_CAMERA_POSITION -63.3 933.9 12.9 0.0 0.0 0.0 
POINT_CAMERA_AT_POINT -78.1 930.8 10.5 JUMP_CUT

IF NOT IS_CHAR_DEAD mercedes
	SET_CHAR_COORDINATES mercedes -62.3 933.6 9.9
ENDIF
  
IF NOT IS_CHAR_DEAD candy_sexxx
	SET_CHAR_COORDINATES candy_sexxx -62.3 935.6 9.9
ENDIF
timerb = 0

WHILE NOT LOCATE_CHAR_ANY_MEANS_2D candy_sexxx -75.25 930.9 1.0 1.0 FALSE
AND	timerb < 8000
	WAIT 0
	IF NOT IS_CHAR_DEAD candy_sexxx
	ENDIF
ENDWHILE

LOAD_MISSION_AUDIO 1 PRN1_11

WHILE NOT HAS_MISSION_AUDIO_LOADED 1
	WAIT 0
ENDWHILE 

PRINT_NOW POR1_17 4000 1//Whoa, cool shark!
PLAY_MISSION_AUDIO 1
WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
AND NOT IS_CHAR_DEAD candy_sexxx  
	WAIT 0
ENDWHILE
CLEAR_MISSION_AUDIO 1
CLEAR_THIS_PRINT POR1_17 

DELETE_CHAR candy_sexxx
DELETE_CHAR mercedes
RESTORE_CAMERA_JUMPCUT
SET_CAMERA_BEHIND_PLAYER
SET_PLAYER_CONTROL player1 ON
SWITCH_WIDESCREEN OFF

GOTO mission_passed_porn1 


// Mission failed
mission_failed_porn1:

PRINT_BIG ( M_FAIL ) 5000 1	//"Mission Failed!"
RETURN

   

// mission passed
mission_passed_porn1:

CLEAR_PRINTS
PRINT_WITH_NUMBER_BIG ( M_PASS ) 1000 5000 1 //"Mission Passed!"
PLAY_MISSION_PASSED_TUNE 1 
CLEAR_WANTED_LEVEL player1
ADD_SCORE player1 1000
PLAYER_MADE_PROGRESS 1 
REGISTER_MISSION_PASSED PORN_1
START_NEW_SCRIPT porn_mission2_loop
flag_porn_mission1_passed = 1
RETURN
		


// mission cleanup
mission_cleanup_porn1:
flag_player_on_mission = 0

SET_PLAYER_CONTROL player1 on
MARK_MODEL_AS_NO_LONGER_NEEDED WMYPI
MARK_MODEL_AS_NO_LONGER_NEEDED BMYCR
MARK_MODEL_AS_NO_LONGER_NEEDED HMYRI
MARK_MODEL_AS_NO_LONGER_NEEDED sentinel
MARK_MODEL_AS_NO_LONGER_NEEDED bat
MARK_MODEL_AS_NO_LONGER_NEEDED tec9
MARK_MODEL_AS_NO_LONGER_NEEDED stretch
REMOVE_CHAR_ELEGANTLY candy_sexxx
REMOVE_CHAR_ELEGANTLY mercedes
UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
REMOVE_BLIP candy_sexxx_blip 
REMOVE_BLIP	mercedes_blip
//REMOVE_BLIP pap_car_blip 
REMOVE_BLIP pap_man_blip 
REMOVE_BLIP pron_studio
GET_GAME_TIMER timer_mobile_start
MISSION_HAS_FINISHED
RETURN
}		


			