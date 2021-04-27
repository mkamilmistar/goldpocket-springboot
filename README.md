# Gold-Pocket App
## Melihat detail pocket
Path: /pocket/{id}

Method: GET

## Dapat melihat list of pocket dari customer tertentu
Path: /customer/{id}/pockets

Method: GET

## Melihat list of purchase
Path: /purchases

Method: GET

## Purchase Product w/ Buy or Sell
Path: /purchase

Method: POST

body: 
```
{
    "purchaseType": 1,
    "purchaseDetails": [
        {
            "quantityInGram":2,
            "pocket": {
                "id" : "4028abff7913aaf1017913abc9020000"
            }
        }
    ]
}
```