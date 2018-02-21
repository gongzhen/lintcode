//
//  TrieNode.h
//  LC
//
//  Created by ULS on 2/15/18.
//  Copyright © 2018 ULS. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface TrieNode : NSObject

@property (strong, nonatomic) NSMutableArray *children;
@property (assign) BOOL isWord;

@end
