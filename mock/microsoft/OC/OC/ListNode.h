//
//  ListNode.h
//  LC
//
//  Created by ULS on 2/14/18.
//  Copyright © 2018 ULS. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface ListNode : NSObject

@property(assign)NSInteger val;
@property(nonatomic, strong) ListNode* next;

- (instancetype)initWith:(NSInteger)x;

@end
