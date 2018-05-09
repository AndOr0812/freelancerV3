import { combineReducers } from 'redux';
import userProfileReducer from './userprofile';
import imageReducer from './imagereducer';
import profileDetailsReducer from './profiledetailreducer';
import allOpenProjects from './allOpenProjects';
import relevantProjects from './relevantProjects';
import projectDetails from './projectDetailsReducer';
import myBids from './myBids';
import {reducer as formReducer} from 'redux-form';
const rootReducer = combineReducers({
    userProfile : userProfileReducer,
    profileDetails: profileDetailsReducer,
    images: imageReducer,
    allOpenProjects:allOpenProjects,
    projectDetails: projectDetails,
    relevantProjects: relevantProjects,
    myBids: myBids,
    form : formReducer
});

export default rootReducer;
