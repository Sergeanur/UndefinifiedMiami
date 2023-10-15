MISSION_START
			  

mission_start_buypro4:

SCRIPT_NAME	buypro4

flag_player_on_mission = 1
IF flag_player_on_mission = 0
	ADD_SHORT_RANGE_SPRITE_BLIP_FOR_CONTACT_POINT strpbuyX strpbuyY strpbuyZ RADAR_SPRITE_STRIPCLUB strpbuy_blip 
	CHANGE_BLIP_DISPLAY strpbuy_blip BLIP_ONLY
ENDIF

WAIT 0
{

	REMOVE_BLIP strpbuy_blip
	PLAYER_MADE_PROGRESS 1

	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_OUT
	SET_PLAYER_CONTROL player1 OFF
	SET_EVERYONE_IGNORE_PLAYER player1 TRUE
	SET_ALL_CARS_CAN_BE_DAMAGED FALSE
	WHILE GET_FADING_STATUS
		WAIT 0
		IF NOT IS_PLAYER_PLAYING player1
			ADD_SHORT_RANGE_SPRITE_BLIP_FOR_CONTACT_POINT strpbuyX strpbuyY strpbuyZ RADAR_SPRITE_STRIPCLUB strpbuy_blip 
			CHANGE_BLIP_DISPLAY strpbuy_blip BLIP_ONLY
			//START_NEW_SCRIPT strpbuy_save_loop
			flag_membership = 1
			TERMINATE_THIS_SCRIPT
		ENDIF
	ENDWHILE

	ADD_SHORT_RANGE_SPRITE_BLIP_FOR_CONTACT_POINT strpbuyX strpbuyY strpbuyZ RADAR_SPRITE_STRIPCLUB strpbuy_blip 
	CHANGE_BLIP_DISPLAY strpbuy_blip BLIP_ONLY
	START_NEW_SCRIPT strpbuy_save_loop
	flag_membership = 1
	CREATE_CLOTHES_PICKUP 158.3 -1275.9 10.6 9 clothes_pickup8
	clothes8_created = 1
	START_NEW_SCRIPT cloth7

	CLEAR_AREA 100.9297 -1470.6222 9.3871 1.0 TRUE
	SET_PLAYER_COORDINATES player1 100.9297 -1470.6222 9.3871
	SET_PLAYER_HEADING player1 218.0275
	SWITCH_WIDESCREEN ON

	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_IN

	SET_FIXED_CAMERA_POSITION 112.9674 -1486.2183 11.2691 0.0 0.0 0.0
	POINT_CAMERA_AT_POINT 112.1791 -1485.6305 11.4509 JUMP_CUT

	WHILE GET_FADING_STATUS
		WAIT 0
		IF NOT IS_PLAYER_PLAYING player1
			TERMINATE_THIS_SCRIPT
		ENDIF
	ENDWHILE

	PRINT_WITH_NUMBER_BIG STRPBUY strpbuy_price 5000 6 //"Pole Position Club membership purchased: $ 15000"
	ADD_MONEY_SPENT_ON_PROPERTY strpbuy_price
	SET_PROPERTY_AS_OWNED PROP_STRIPCLUB
//	strpbuy_price *= -1
//	ADD_SCORE player1 strpbuy_price
	PLAY_MISSION_PASSED_TUNE 1
	SET_MUSIC_DOES_FADE FALSE

	WAIT 4000

	IF NOT IS_PLAYER_PLAYING player1
		SET_MUSIC_DOES_FADE TRUE
		TERMINATE_THIS_SCRIPT
	ENDIF

	//SET_FIXED_CAMERA_POSITION 97.5334 -1473.4329 11.0017 0.0 0.0 0.0
	//POINT_CAMERA_AT_POINT 97.9273 -1472.5416 10.7771 JUMP_CUT

	//PRINT_NOW BUYSAVE 3000 1//~g~You can now save your game here for free.
	//WAIT 3000

	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_OUT

	WHILE GET_FADING_STATUS
		WAIT 0
		IF NOT IS_PLAYER_PLAYING player1
			SET_MUSIC_DOES_FADE TRUE
			TERMINATE_THIS_SCRIPT
		ENDIF
	ENDWHILE

	SET_CAMERA_BEHIND_PLAYER
	RESTORE_CAMERA_JUMPCUT

	SET_PLAYER_CONTROL player1 ON
	SET_EVERYONE_IGNORE_PLAYER player1 FALSE
	SET_ALL_CARS_CAN_BE_DAMAGED TRUE
	SWITCH_WIDESCREEN OFF

	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_IN

	WHILE GET_FADING_STATUS
		WAIT 0
	ENDWHILE

	SET_MUSIC_DOES_FADE TRUE
					
												
flag_player_on_mission = 0

MISSION_HAS_FINISHED
MISSION_END

}
RETURN 

