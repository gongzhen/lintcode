//
//  TrieNode.m
//  LC
//
//  Created by ULS on 2/15/18.
//  Copyright © 2018 ULS. All rights reserved.
//
#import "TrieNode.h"

@interface TrieNode()

@end

@implementation TrieNode

- (instancetype)init {
    if(self = [super init]) {
        _children = [NSMutableArray arrayWithCapacity:26];
        for(NSInteger i = 0; i < 26; i++) {
            [_children addObject:[NSNull null]];
        }
        _isWord = NO;
    }
    return self;
}
@end

