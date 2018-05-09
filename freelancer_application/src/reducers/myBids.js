import React,{ Component } from 'react';
import {MY_BIDS} from '../actions';

export default function (state = [],action) {
    switch (action.type) {
        case MY_BIDS:
            return state= action.payload;
        default:
            return state;
    }
}