Spring with Firebase Database
========================


#### Example how you can work with Firebase with Spring Framework. Use it as a template.


### What to do first

- This project has Code Styles the <a href="https://github.com/square/java-code-styles">Square</a>.
- If you're using IDEA, remember to enable annotation processing. Lombok library is used.
- Create a new Firebase Project <a href="https://console.firebase.google.com/">Firebase Console</a>
- Under /settings/serviceaccounts/adminsdk get a Private Key. Rename the json file to serviceAccountKey.json and store it under /resources in the app.
- Go to Database and see the URL.
- The database rules should be
~~~~
{
  "rules": {
    ".read": false,
    ".write": false
  }
}
~~~~
- In case you are wondering, you have the json key file, so you are already admin.
- Make sure you're reading the json.key file correctly in by application, wherever you decide to store it.


### What to do next

Check the code. It's easy and you can figure out what's going on there

 
### Feedback

I don't have much experience with Spring, so if you see something that can be improved, please do tell.

##### License: Apache 2.0

~~~~
Copyright 2016 AndroidAdvance.com

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
~~~~
limitations under the License.
