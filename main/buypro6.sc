MISSION_START
			  

mission_start_lnkvbuy:

SCRIPT_NAME	lnkvbuy

flag_player_on_mission = 1

//304.5807 376.3138 12.1856 269.8422 
  
WAIT 0
{

	REMOVE_BLIP lnkvbuy_blip
	PLAYER_MADE_PROGRESS 1

	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_OUT
	SET_PLAYER_CONTROL player1 OFF
	SET_EVERYONE_IGNORE_PLAYER player1 TRUE
	SET_ALL_CARS_CAN_BE_DAMAGED FALSE
	WHILE GET_FADING_STATUS
		WAIT 0
		IF NOT IS_PLAYER_PLAYING player1
			ADD_SHORT_RANGE_SPRITE_BLIP_FOR_CONTACT_POINT lnkvbuyX lnkvbuyY lnkvbuyZ RADAR_SPRITE_SAVEHOUSE lnkvbuy_blip 
			CHANGE_BLIP_DISPLAY lnkvbuy_blip BLIP_ONLY
			START_NEW_SCRIPT lnkvsave1_save_loop
			TERMINATE_THIS_SCRIPT
		ENDIF
	ENDWHILE

	ADD_SHORT_RANGE_SPRITE_BLIP_FOR_CONTACT_POINT lnkvbuyX lnkvbuyY lnkvbuyZ RADAR_SPRITE_SAVEHOUSE lnkvbuy_blip 
	CHANGE_BLIP_DISPLAY lnkvbuy_blip BLIP_ONLY
	START_NEW_SCRIPT lnkvsave1_save_loop

	CLEAR_AREA 306.5728 376.2928 12.1856 1.0 TRUE
	SET_PLAYER_COORDINATES player1 306.5728 376.2928 12.1856
	SET_PLAYER_HEADING player1 276.3156
	SWITCH_WIDESCREEN ON

	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_IN

	SET_FIXED_CAMERA_POSITION 241.4097 420.0691 10.3880 0.0 0.0 0.0
	POINT_CAMERA_AT_POINT 242.1410 419.4232 10.6071 JUMP_CUT

	WHILE GET_FADING_STATUS
		WAIT 0
		IF NOT IS_PLAYER_PLAYING player1
			TERMINATE_THIS_SCRIPT
		ENDIF
	ENDWHILE

	links_view_bought = 1
	//CREATE_CLOTHES_PICKUP 304.6 372.2 13.2 1 safehouse_clothes6   
	safehouse_created6 = 1
	PRINT_WITH_NUMBER_BIG LNKVBUY lnkvbuy_price 5000 6 //"Links View Apartment purchased: $ 15000"
	ADD_MONEY_SPENT_ON_PROPERTY lnkvbuy_price
	SET_PROPERTY_AS_OWNED PROP_LINKSVIEW
	//lnkvbuy_price *= -1
	//ADD_SCORE player1 lnkvbuy_price
	PLAY_MISSION_PASSED_TUNE 1
	SET_MUSIC_DOES_FADE FALSE

	WAIT 2000

//	IF NOT IS_PLAYER_PLAYING player1
//		SET_MUSIC_DOES_FADE TRUE
//		TERMINATE_THIS_SCRIPT
//	ENDIF
//
//	SET_FIXED_CAMERA_POSITION 308.0695 369.4077 12.9178 0.0 0.0 0.0
//	POINT_CAMERA_AT_POINT 307.5253 370.2357 13.0535 JUMP_CUT

	PRINT_NOW BUYSAVE 3000 1//~g~You can now save your game here for free.

	WAIT 3000

	SET_FIXED_CAMERA_POSITION 313.6496 390.9760 14.5314 0.0 0.0 0.0
	POINT_CAMERA_AT_POINT 313.0024 391.7380 14.5534 JUMP_CUT

	PRINT_NOW BUYGARG 3000 1//~g~You can also store vehicles in this garage.
	CHANGE_GARAGE_TYPE lnkvbuy_save_garage GARAGE_HIDEOUT_SIX 

	WAIT 3000

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

	GOSUB get_fading_status

	SET_MUSIC_DOES_FADE TRUE
					
												
flag_player_on_mission = 0

MISSION_HAS_FINISHED
MISSION_END

}
RETURN 
