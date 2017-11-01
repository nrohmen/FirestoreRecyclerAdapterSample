# FirestoreRecyclerAdapterSample
Sample Android project using `FirestoreRecyclerAdapter`. This project is using Firebase Cloud Firestore as a databases.

## Using `FirestoreRecyclerAdapter` to populate `RecyclerView`
Before you create the create the project in Android Studio, you should:
1. Create a Firebase Project [here][firestore-console].
2. Go to Database menu and choose Cloud Firestore.
3. Add Collection named `"friends"`.
4. In the `"firends"` collection, add some documents with some field `(name, image, title, company)` in the each documents.
Also you should integrate the Firebase project with the project that will you create in Android Studio. For more information, go to the [Firebase Docs][firestore-docs].

### Dependencies
Some dependencies thats should be implemented in your project:
```gradle
implementation "com.google.firebase:firebase-firestore:11.4.2"
implementation "com.firebaseui:firebase-ui-auth:3.0.0"
implementation "com.firebaseui:firebase-ui-firestore:3.0.0"
```
### Query
To retrive all documents in the collection use:
```java
Query query = db.collection("friends");
```
### Using FirestoreRecyclerAdapter
Configure the adapter by building `FirestoreRecyclerOptions`:
```java
 FirestoreRecyclerOptions<FriendsResponse> response = new FirestoreRecyclerOptions.Builder<FriendsResponse>()
                .setQuery(query, FriendsResponse.class)
                .build();
```

Create `FirestoreRecyclerAdapter`:
```java
 FirestoreRecyclerAdapter adapter = new FirestoreRecyclerAdapter<FriendsResponse, FriendsHolder>(response) {
            @Override
            public void onBindViewHolder(FriendsHolder holder, int position, FriendsResponse model) {
                progressBar.setVisibility(View.GONE);
                holder.textName.setText(model.getName());
                holder.textTitle.setText(model.getTitle());
                holder.textCompany.setText(model.getCompany());
                Glide.with(getApplicationContext())
                        .load(model.getImage())
                        .into(holder.imageView);

                holder.itemView.setOnClickListener(v -> {
                    Snackbar.make(friendList, model.getName()+", "+model.getTitle()+" at "+model.getCompany(), Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                });
            }

            @Override
            public FriendsHolder onCreateViewHolder(ViewGroup group, int i) {
                View view = LayoutInflater.from(group.getContext())
                        .inflate(R.layout.list_item, group, false);

                return new FriendsHolder(view);
            }

            @Override
            public void onError(FirebaseFirestoreException e) {
                Log.e("error", e.getMessage());
            }
        };
```


[firestore-console]: https://console.firebase.google.com/u/0/
[firestore-docs]: https://firebase.google.com/docs/firestore/
