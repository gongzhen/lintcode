//
//  ListNode.m
//  LC
//
//  Created by ULS on 2/14/18.
//  Copyright © 2018 ULS. All rights reserved.
//

#import "ListNode.h"

@implementation ListNode

- (instancetype)initWith:(NSInteger)x {
    if(self = [super init]) {
        _val = x;
    }
    return self;
}

@end
