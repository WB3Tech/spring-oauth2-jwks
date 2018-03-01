# spring-oauth2-jwks
Demonstrates how to utilize JWKs as a means to validate OAuth2 Bearer Tokens

# Getting Started

1. Go to you AWS Console
2. Find Cognito, and create a user pool.  Once created, make sure to note the Pood Id.
3. Create an 'App client', this is under the 'General Settings' selection list
  1. Make sure 'Enable sign-in API for server-based authentication' is selected
  2. Save Changes
4. Update the 'App client settings', this is under the 'App Integration'selection list
  1. Navigate to the client you created in Step 3.
  2. Select the 'Cognito User Pool' ins the 'Enable Identity Providers' section
  3. Select the 'Authorization code grant' option in the 'Authorization OAuth Flows' section
  4. Select the 'openid' option in the 'Allowed OAuth Scopes' section
  5. Save changes


## Setting up the project

1. Clone this repository
2. Open the 'application.yml' file
3. Add the following two lines:
  1. 'user-info-uri'    |     You will need the name of your user pool, and the AWS region the Cognito service is in
  2. 'key-set-uri'      |     You will need the Pool Id and the, and the AWS region the Cognito service is in
  
```
security:
    oauth2:
        resource:
          prefer-token-info: ${OAUTH2_RESOURCE_PREFER_TOKEN_INFO:false}
          user-info-uri: https://[Cognito-Pool-Name].[region].amazoncognito.com/oauth2/userInfo
          jwk:
            key-set-uri: https://cognito-idp.[region].amazonaws.com/[Pool-Id]/.well-known/jwks.json
```


## Running the project
Once both setup steps are complete, run the project.  It should default to http://localhost:8080.

Use a tool such as Postman to hit the http://localhost:8080/ endpoint.  Make sure to use the following uris for the OAuth Authorization flow :

- Grant Type:             Authoization Code
- Callback Url:           http://localhost:8080
- Auth Url:               https://[Cognito-Pool-Name].auth.us-east-1.amazoncognito.com/oauth2/authorize
- Access Token Url:       https://[Cognito-Pool-Name].auth.us-east-1.amazoncognito.com/oauth2/token
- Client Id:              NOTE: Get this from your inside your User Pool at 'General Settings' --> 'App Clients'
- Client Secret:          NOTE: Get this from your inside your User Pool at 'General Settings' --> 'App Clients'
- Scope:                  openid
- Client Authentication:   NOTE: Make sure to send as Basic Auth Header
